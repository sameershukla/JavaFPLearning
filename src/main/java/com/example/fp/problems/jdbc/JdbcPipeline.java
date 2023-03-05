package com.example.fp.problems.jdbc;

import com.example.fp.basics.types.Tuple;
import com.example.fp.basics.types.Unit;

import java.sql.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class JdbcPipeline {

    private static Function<Unit, Connection> createConnection = (u) -> {
        String url = "jdbc:h2:mem:testdb";
        String user = "sa";
        String password = "password";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    private static Tuple<Connection, ResultSet> executeQuery(Connection conn, String query){
            try {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(query);
                statement.close();
                return new Tuple<>(conn, rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    };

    private static Tuple<Connection, ResultSet> executeResultSet(Tuple<Connection, ResultSet> tuple) {
        ResultSet rs = tuple._2();
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department + ", Salary: " + salary);
            }
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        return tuple;
    };

    private static Unit closeConnection(Tuple<Connection, ResultSet> tuple){
        try {
            tuple._1().close();
            tuple._2().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Unit.unit();
    }


    public static void main(String[] args) {
         createConnection
                 .andThen(x -> executeQuery(x, "SELECT * FROM Employee"))
                 .andThen(tuple -> executeResultSet(tuple))
                 .andThen(tuple -> closeConnection(tuple))
                 .apply(Unit.unit());
    }


}

# Functional Programming In Java

<img src="https://axisapplications.com/wp-content/uploads/2019/02/functionalprogramming_icon-300x300.png" width="300">


The Repository is a compendium of Java-based Functional Programming examples aimed at enhancing your comprehension of the concepts and facilitating your eventual implementation of them.

# Package info

##### 1. _functional.basics_: Contains examples of function chaining, the package has example of Function, BiFunction and user-defined TriFunction chaining.

##### 2. _functional.tuple_: A tuple is similar to an array, but unlike an array, it can hold elements of different types, and it has a fixed length. Tuples are a convenient way to group together related data that doesn't naturally fit into a class or a case class. The Tuple is a user-defined class.

##### _3. functional.currying:_ Contains examples of Currying

# Fundamentals

  In Java, a lambda expression is a type of anonymous function that can be used to represent a block of code that can be passed as an argument to a method or stored in a variable. When a Java compiler encounters a lambda expression in the source code, it performs several steps to detect and process it:
   
   ##### **_Parsing_**: The Java compiler parses the lambda expression to determine its syntax and identify the variables that are used in the expression.
   
   ##### **_Type_ _Inference_**: The compiler infers the types of the lambda parameters based on the context in which the lambda expression is used.
   
   ##### **Creation of a Functional Interface**:_ A lambda expression is only valid if it can be assigned to a functional interface. A functional interface is an interface with a single abstract method. If the lambda expression matches the signature of the functional interface, the compiler creates an instance of that interface and assigns the lambda expression to it.
    
   ##### **Compilation**_: Finally, the compiler compiles the lambda expression and generates bytecode that can be executed by the Java Virtual Machine (JVM).

   During compilation, the lambda expression is translated into a class file that implements the functional interface. The class file contains a method that implements the lambda expression, as well as any captured variables and their values. When the lambda expression is executed, the JVM creates an instance of this class and invokes the method on that instance.


# Function Chaining

   In order to create a chain of functions, it is essential to first instantiate a Function or BiFunction object.
   This marks the beginning of the pipeline. For example, you could create a Function<String, String> object named "pipeline" using the
   "createReader" method of the "FileOps" class. Once you have created the "pipeline" object, you can use the "andThen" method to chain subsequent functions together.
   Each function in the chain will take the output of the preceding function as input. Eventually, the final function in the chain should return a String value.

   Function<String, String> pipeline = FileOps :: createReader;

   pipeline.andThen("Output of Create Reader is input here") and so on, but eventually it should return String.

   more details can be found here: https://www.c-sharpcorner.com/article/creating-function-pipelines-in-java/

# Function Chaining Use Cases

**Data processing**: Function chaining can be used to perform a series of data transformations on a collection or stream of data, such as filtering, mapping, sorting, and reducing. By chaining these operations together, you can create a data processing pipeline that is both efficient and easy to read and maintain.

**Input validation**: Function chaining can be used to validate user input by applying a series of validation rules to the input data. Each function in the chain can check a specific aspect of the input, such as its length, format, or range, and return an error message if the input fails the validation.

**Logging and debugging**: Function chaining can be used to create a chain of logging or debugging statements that track the execution of a program or a specific code path. Each function in the chain can output a specific piece of information, such as the input or output data, the execution time, or the error message, and pass the output to the next function in the chain.

**Configuration and setup**: Function chaining can be used to configure and set up a complex system or application. Each function in the chain can perform a specific configuration task, such as initializing a database connection, setting up a network connection, or loading a configuration file, and pass the configuration data to the next function in the chain.

In general, function chaining can be used in any situation where you need to compose a series of related functions to perform a specific task or data transformation. By chaining the functions together, you can create a powerful and flexible pipeline that is both easy to use and easy to maintain.

# Function Chaining Methods and Interfaces

**andThen Function:** The Function interface's "andThen" method takes a sequence of two functions and applies them in succession, using the output of the first function as the input to the second function. This chaining of the functions results in a new function that combines the behavior of both functions in a single transformation. Here's an example:

   Function<Integer, Integer> addOne = x -> x + 1;
   Function<Integer, Integer> doubleIt = x -> x * 2;
   Function<Integer, Integer> addOneAndDoubleIt = addOne.andThen(doubleIt);

   System.out.println(addOneAndDoubleIt.apply(5)); // Output: 12



**compose Function:** In contrast to the "andThen" method, the "compose" method applies the first function to the output of the second function. This means that the second function is applied to the input, and then the first function is applied to the output of the second function. This results in a chain of functions where the output of the second function becomes the input of the first function.. Here's an example:

   Function<Integer, Integer> addOne = x -> x + 1;
   Function<Integer, Integer> doubleIt = x -> x * 2;
   Function<Integer, Integer> addOneAfterDoubleIt = addOne.compose(doubleIt);

   System.out.println(addOneAfterDoubleIt.apply(5)); // Output: 11


**BiFunction Interface:** BiFunction can be represented as Function<A, Function<A, B>>

      ```
      /**
      * Input is Function<String, Function<String,String>>
      *     Input to Function is String and output is a second function
      *       Input to second function is String and output is a String, hence on apply.apply a String is returned
      *        Input to first function (s1) output is a function (s2) -> s1 + s2
      *          Input to second function is (s2) output is s1 + s2
      *
      */
      (s1) -> (s2) -> s1 + s2
      private static String function(Function<String, Function<String, String>> f){
         return f.apply("Hello").apply("World");
      }
      
      (s1, s2) -> s1 + s2 
      private static String biFunc(BiFunction<String, String, String> b){
        return b.apply("Hello", "World");
     }
      ```

**TriFunction:** If we require more than two parameters to be passed to a function, such as three parameters, we may encounter a problem as there is no TriFunction interface available in Java. However, there are two potential solutions to this issue.
   The first is to create our own TriFunction interface, which would resemble something like:,

      ```
      @FunctionalInterface
      public interface TriFunction<A, B, C, R> {
           R apply(A a, B b, C c);

           default <R> TriFunction<A, B, C, R> andThen(TriFunction<A, B, C, R> after) {
              return (A a, B b, C c) -> after.apply(a,b,c);
            }
      }
     ```
If we need to pass more than three parameters to a function, it can become a difficult problem to solve. In such cases, using currying can be the most effective approach. 
By breaking down the function into a series of nested functions, each taking one argument, we can create a more flexible and reusable solution.

# Currying

   Function currying is a technique that involves breaking down a function that takes multiple arguments into a series of functions that each take a single argument.
   In other words, it transforms a function that takes multiple arguments into a chain of functions that each take a single argument and return a new function until all the original arguments are consumed.
   Java's Function interface supports currying through the use of the "andThen" and "compose" methods. These methods enable the creation of a sequence of functions where the output of one function is used as the input of another function. By chaining functions together in this way, it is possible to create a pipeline of transformations that can be applied to data in a flexible and modular way.
   Currying has several benefits, including making it easier to reuse and compose functions, and enabling functions to be partially applied with some of their arguments fixed at runtime. This can lead to more modular, maintainable code and can simplify the development process. However, it's important to use currying judiciously and to avoid creating overly complex function chains that are difficult to reason about.

   ```
      //Currying with 2 params
      Function<Integer, Function<Integer, Integer>> add = (param1) -> (param2) -> param1 + param2; 
   
      //Currying with 3 params
      Function<String, Function<String, Function<String, String>>> curry = (f) -> (s) -> (t) -> f + " "+ s + " " + t;
      System.out.println(curry.apply("Java").apply("Programming").apply("Language")); # Java Programming Language
   
   ```

# Currying Use Cases

**Configuring database access:** When connecting to a database, it's often necessary to provide credentials and other configuration parameters. Using a curried function to handle the configuration allows for greater flexibility and reuse of code. For example, we can create a function that takes the database URL as input and returns another function that takes the username and password as input and returns a database connection.

**Filtering and sorting data:** When working with large datasets, it can be useful to create functions that filter and sort the data according to specific criteria. Using function currying to create reusable filters and sorters allows for greater flexibility and efficiency in data processing. For example, we can create a function that takes a list of strings as input and returns another function that filters the list to include only strings that contain a specific substring.

**Event-driven programming:** In event-driven programming, it's common to register listeners or callbacks that are triggered when specific events occur. Using function currying to register listeners and callbacks can make the code more flexible and easier to maintain. For example, we can create a function that takes an event type as input and returns another function that takes a listener function as input and registers the listener for that event type.

**Service composition:** In a service-oriented architecture, it's common to compose services by chaining together functions that handle different aspects of the service. Using function currying to chain together functions allows for greater flexibility and adaptability in service composition. For example, we can create a function that takes a URL as input and returns another function that fetches data from that URL, then another function that processes the data, and so on.

# MONADS

@author: Sameer Shukla

   
   
   
   
   
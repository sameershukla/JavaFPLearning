# Functional Programming In Java

The Repository is a compendium of Java-based Functional Programming examples aimed at enhancing your comprehension of the concepts and facilitating your eventual implementation of them.

# Package info

1. functional.basics: Contains examples of function chaining, the package has example of Function, BiFunction and user-defined
   TriFunction chaining.

2. Tuple: A tuple is similar to an array, but unlike an array, it can hold elements of different types, and it has a fixed length. Tuples are a convenient way to group together related data that doesn't naturally fit into a class or a case class.
   The Tuple is a user-defined class.

3. Currying: Contains examples of Currying

# Fundamentals

1. In Java, a lambda expression is a type of anonymous function that can be used to represent a block of code that can be passed as an argument to a method or stored in a variable. When a Java compiler encounters a lambda expression in the source code, it performs several steps to detect and process it:
   **Parsing**: The Java compiler parses the lambda expression to determine its syntax and identify the variables that are used in the expression.
   **Type Inference**: The compiler infers the types of the lambda parameters based on the context in which the lambda expression is used.
   **Creation of a Functional Interface**: A lambda expression is only valid if it can be assigned to a functional interface. A functional interface is an interface with a single abstract method. If the lambda expression matches the signature of the functional interface, the compiler creates an instance of that interface and assigns the lambda expression to it.
   **Compilation**: Finally, the compiler compiles the lambda expression and generates bytecode that can be executed by the Java Virtual Machine (JVM).
   During compilation, the lambda expression is translated into a class file that implements the functional interface. The class file contains a method that implements the lambda expression, as well as any captured variables and their values. When the lambda expression is executed, the JVM creates an instance of this class and invokes the method on that instance.


2. In order to create a chain of functions, it is essential to first instantiate a Function or BiFunction object.
   This marks the beginning of the pipeline. For example, you could create a Function<String, String> object named "pipeline" using the
   "createReader" method of the "FileOps" class. Once you have created the "pipeline" object, you can use the "andThen" method to chain subsequent functions together.
   Each function in the chain will take the output of the preceding function as input. Eventually, the final function in the chain should return a String value.

   Function<String, String> pipeline = FileOps :: createReader;

   pipeline.andThen("Output of Create Reader is input here") and so on, but eventually it should return String.

   more details can be found here: https://www.c-sharpcorner.com/article/creating-function-pipelines-in-java/


3. andThen Function: The Function interface's "andThen" method takes a sequence of two functions and applies them in succession, using the output of the first function as the input to the second function. This chaining of the functions results in a new function that combines the behavior of both functions in a single transformation. Here's an example:

   Function<Integer, Integer> addOne = x -> x + 1;
   Function<Integer, Integer> doubleIt = x -> x * 2;
   Function<Integer, Integer> addOneAndDoubleIt = addOne.andThen(doubleIt);

   System.out.println(addOneAndDoubleIt.apply(5)); // Output: 12

4. compose Function: In contrast to the "andThen" method, the "compose" method applies the first function to the output of the second function. This means that the second function is applied to the input, and then the first function is applied to the output of the second function. This results in a chain of functions where the output of the second function becomes the input of the first function.. Here's an example:

   Function<Integer, Integer> addOne = x -> x + 1;
   Function<Integer, Integer> doubleIt = x -> x * 2;
   Function<Integer, Integer> addOneAfterDoubleIt = addOne.compose(doubleIt);

   System.out.println(addOneAfterDoubleIt.apply(5)); // Output: 11


5. BiFunction can be represented as Function<A, Function<A, B>> 

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

6. TriFunction: If we require more than two parameters to be passed to a function, such as three parameters, we may encounter a problem as there is no TriFunction interface available in Java. However, there are two potential solutions to this issue. 
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
   But in that case if we need to pass more than 3 then it's a forever problem to solve, the best approach would be to apply Currying.  

7. Currying: Function currying is a technique that involves breaking down a function that takes multiple arguments into a series of functions that each take a single argument. 
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

   
   
   
   
   
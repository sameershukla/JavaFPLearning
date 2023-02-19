# functional_programming_notes

The Repository is a compendium of Java-based Functional Programming examples aimed at enhancing your comprehension of the concepts and facilitating your eventual implementation of them.

# Package info

1. functional.basics: Contains examples of function chaining, the package has example of Function, BiFunction and user-defined
   TriFunction chaining.

2. Tuple: A tuple is similar to an array, but unlike an array, it can hold elements of different types, and it has a fixed length. Tuples are a convenient way to group together related data that doesn't naturally fit into a class or a case class.
   The Tuple is a user-defined class.

3. Currying: Contains examples of Currying
# Fundamentals

1. In order to create a chain of functions, it is essential to first instantiate a Function or BiFunction object.
   This marks the beginning of the pipeline. For example, you could create a Function<String, String> object named "pipeline" using the
   "createReader" method of the "FileOps" class. Once you have created the "pipeline" object, you can use the "andThen" method to chain subsequent functions together.
   Each function in the chain will take the output of the preceding function as input. Eventually, the final function in the chain should return a String value.

   Function<String, String> pipeline = FileOps :: createReader;

   pipeline.andThen("Output of Create Reader is input here") and so on, but eventually it should return String.

   more details can be found here: https://www.c-sharpcorner.com/article/creating-function-pipelines-in-java/


2. andThen Function: The Function interface's "andThen" method takes a sequence of two functions and applies them in succession, using the output of the first function as the input to the second function. This chaining of the functions results in a new function that combines the behavior of both functions in a single transformation. Here's an example:

   Function<Integer, Integer> addOne = x -> x + 1;
   Function<Integer, Integer> doubleIt = x -> x * 2;
   Function<Integer, Integer> addOneAndDoubleIt = addOne.andThen(doubleIt);

   System.out.println(addOneAndDoubleIt.apply(5)); // Output: 12

3. compose Function: In contrast to the "andThen" method, the "compose" method applies the first function to the output of the second function. This means that the second function is applied to the input, and then the first function is applied to the output of the second function. This results in a chain of functions where the output of the second function becomes the input of the first function.. Here's an example:

   Function<Integer, Integer> addOne = x -> x + 1;
   Function<Integer, Integer> doubleIt = x -> x * 2;
   Function<Integer, Integer> addOneAfterDoubleIt = addOne.compose(doubleIt);

   System.out.println(addOneAfterDoubleIt.apply(5)); // Output: 11


4. BiFunction can be represented as Function<A, Function<A, B>> example, check FunctionExplorer class

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

5. Currying: Function currying is a technique that involves breaking down a function that takes multiple arguments into a series of functions that each take a single argument. In other words, it transforms a function that takes multiple arguments into a chain of functions that each take a single argument and return a new function until all the original arguments are consumed.
   Java's Function interface supports currying through the use of the "andThen" and "compose" methods. These methods enable the creation of a sequence of functions where the output of one function is used as the input of another function. By chaining functions together in this way, it is possible to create a pipeline of transformations that can be applied to data in a flexible and modular way.

   Currying has several benefits, including making it easier to reuse and compose functions, and enabling functions to be partially applied with some of their arguments fixed at runtime. This can lead to more modular, maintainable code and can simplify the development process. However, it's important to use currying judiciously and to avoid creating overly complex function chains that are difficult to reason about.


   
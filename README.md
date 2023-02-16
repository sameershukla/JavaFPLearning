# functional_programming_notes

The Repository is a compendium of Java-based Functional Programming examples aimed at enhancing your comprehension of the concepts and facilitating your eventual implementation of them.

# Package info
1. Chaining Package: Contains examples of function chaining, the package has example of Function, BiFunction and user-defined 
   TriFunction chaining. 
2. Tuple: A tuple is similar to an array, but unlike an array, it can hold elements of different types, and it has a fixed length. Tuples are a convenient way to group together related data that doesn't naturally fit into a class or a case class.
   The Tuple is a user-defined class. 

# Fundamentals

1. For chaining it's important to first create a instance of Function, BiFunction that's when the Pipeline begins 

   Function<String, String> pipeline = FileOps :: createReader;
   
   pipeline.andThen("Output of Create Reader is input here") and so on, but eventually it should return String. 
   
   more details can be found here: https://www.c-sharpcorner.com/article/creating-function-pipelines-in-java/ 

2. andThen Function: The andThen method in the Function interface applies the first function to the input, and then applies the second function to the output of the first function. In other words, it chains the two functions together so that the output of the first function becomes the input of the second function. Here's an example:

   Function<Integer, Integer> addOne = x -> x + 1;
   Function<Integer, Integer> doubleIt = x -> x * 2;
   Function<Integer, Integer> addOneAndDoubleIt = addOne.andThen(doubleIt);

   System.out.println(addOneAndDoubleIt.apply(5)); // Output: 12

3. compose Function: The compose method, on the other hand, applies the second function to the input, and then applies the first function to the output of the second function. In other words, it chains the two functions together so that the output of the second function becomes the input of the first function. Here's an example:

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


   
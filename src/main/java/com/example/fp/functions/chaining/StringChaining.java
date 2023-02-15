package src.main.java.com.example.fp.functions.chaining;

import java.util.function.Function;

public class StringChaining {

    private static String addText(String text){
        return text;
    }

    private static String removeSpecialCharacters(String text){
        return text.replaceAll("[^\\p{Alpha}]+", " ");
    }

    private static String capitalize(String text){
        return text.toUpperCase();
    }

    public static void main(String[] args) {
        Function<String, String> pipeline = StringChaining:: addText;
        String result = pipeline
                            .andThen(StringChaining:: removeSpecialCharacters)
                            .andThen(StringChaining:: capitalize)
                            .apply("Hello");
        System.out.println(result);
    }
}

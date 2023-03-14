package com.example.fp.basics.composition.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class FileReaderPipeline {

    static Function<String, String> trim = String::trim;
    static Function<String, String> toUpperCase = String::toUpperCase;
    static Function<String, String> replaceSpecialCharacters = str -> str.replaceAll("[^\\p{Alpha}]+", "");

    static Function<String, String> pipeline = trim
                                                .andThen(toUpperCase)
                                                .andThen(replaceSpecialCharacters);

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String result = pipeline.apply(line);
                System.out.println(result);
            }
        }
    }
}

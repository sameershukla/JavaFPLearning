package com.example.fp.functional.basics;

import java.io.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class FileOperationPipeline {

    private static String lines;

    /**
     * Create Buffered Reader
     *
     * @param filename
     * @return
     */
    private static BufferedReader createReader(String filename) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(new File(filename)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return br;
    }

    /**
     * ReadLines from the Reader
     *
     * @param br
     * @return
     */
    public static BufferedReader readLines(BufferedReader br) {
        StringBuilder sb = new StringBuilder();
        try {
            while (br.readLine() != null) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lines = sb.toString();
        return br;
    }

    private static void printLines(Consumer<String> cons) {
        cons.accept(lines);
    }

    /**
     * Print Lines
     *
     * @param br
     * @return
     */
    public static BufferedReader print(BufferedReader br) {
        printLines((lines) -> System.out.println(lines));
        return br;
    }

    /**
     * Close Reader
     *
     * @param br
     * @return
     */
    public static BufferedReader closeReader(BufferedReader br) {
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return br;
    }

    public static void main(String[] args) {
        Function<String, BufferedReader> pipeline = FileOperationPipeline::createReader;
        pipeline
                .andThen(FileOperationPipeline::readLines)
                .andThen(FileOperationPipeline::print)
                .andThen(FileOperationPipeline::closeReader)
                .apply("example.txt");
    }
}

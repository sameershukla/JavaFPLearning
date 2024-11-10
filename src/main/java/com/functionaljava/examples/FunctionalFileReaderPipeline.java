package com.functionaljava.examples;

import com.functionaljava.types.Tuple;
import com.functionaljava.types.Unit;
import java.io.*;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Demonstrates a functional approach to file I/O operations using function composition and currying.
 * The pipeline reads a file, processes the lines, prints them, and closes the BufferedReader.
 */
public class FunctionalFileReaderPipeline {

    /**
     * Curried function to create a BufferedReader from a filename.
     * This allows partial application, making it flexible for various input sources.
     */
    private static Function<String, BufferedReader> createBufferedReader = filename -> {
        try {
            return new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("File not found: " + filename, ex);
        }
    };

    /**
     * Reads all lines from a BufferedReader and returns a Tuple containing the BufferedReader and the file content.
     * This allows further operations on the BufferedReader while carrying the content forward.
     */
    private static Tuple<BufferedReader, String> readLines(BufferedReader br) {
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            return new Tuple<>(br, sb.toString());
        } catch (IOException ex) {
            throw new UncheckedIOException("Error reading from BufferedReader", ex);
        }
    }

    /**
     * Prints the lines read from the file to the console.
     * Returns a Tuple containing the BufferedReader and a Unit to signify completion of printing.
     */
    private static Tuple<BufferedReader, Unit> printLines(Tuple<BufferedReader, String> line) {
        System.out.println("File Content:\n" + line._2());
        return new Tuple<>(line._1(), Unit.unit());
    }

    /**
     * Closes the BufferedReader after processing is complete.
     * Returns Unit, indicating the end of the pipeline.
     */
    private static Unit closeBufferedReader(Tuple<BufferedReader, Unit> tuple) {
        try {
            tuple._1().close();
            System.out.println("BufferedReader closed successfully.");
        } catch (IOException e) {
            throw new RuntimeException("Error closing BufferedReader", e);
        }
        return tuple._2();
    }

    /**
     * Main file processing pipeline.
     * Reads a filename from user input, and then creates a pipeline that opens, reads, prints, and closes the file.
     */
    public static void processFileData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename to process: ");
        String filename = scanner.nextLine();

        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("File Argument Cannot be empty");
        }

        // Functional pipeline to process the file data
        createBufferedReader
                .andThen(FunctionalFileReaderPipeline::readLines)
                .andThen(FunctionalFileReaderPipeline::printLines)
                .andThen(FunctionalFileReaderPipeline::closeBufferedReader)
                .apply(filename);
    }

    public static void main(String[] args) {
        processFileData();
    }
}

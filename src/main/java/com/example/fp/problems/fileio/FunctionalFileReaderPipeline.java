package com.example.fp.problems.fileio;

import com.example.fp.basics.types.Tuple;
import com.example.fp.basics.types.Unit;
import java.io.*;
import java.util.Scanner;
import java.util.function.Function;

public class FunctionalFileReaderPipeline {
    private static Function<String, BufferedReader> createBufferedReader = (filename) -> {
        try {
                return new BufferedReader(new FileReader(filename));
            } catch (FileNotFoundException ex) {
                throw new IllegalArgumentException("File not found: " + filename, ex);
            }
     };
    private static Tuple<BufferedReader, String> readLines(BufferedReader br) {
        try {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
                return new Tuple<>(br, sb.toString());
            } catch (IOException ex) {
                throw new UncheckedIOException("Error reading from BufferedReader", ex);
            }
    };
   private static Tuple<BufferedReader, Unit> printLines(Tuple<BufferedReader, String> line) {
        System.out.println(line._2());
        return new Tuple<>(line._1(), Unit.unit());
    }
    private static Unit closeBufferedReader(Tuple<BufferedReader, Unit> tuple){
        try {
            tuple._1().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tuple._2();
    }
    public static void processFileData(){
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        if(filename == null){
            throw new IllegalArgumentException("File Argument Cannot be empty");
        }
        createBufferedReader
                .andThen(FunctionalFileReaderPipeline:: readLines)
                .andThen(FunctionalFileReaderPipeline:: printLines)
                .andThen(FunctionalFileReaderPipeline:: closeBufferedReader)
                .apply(filename);
    }
    public static void main(String[] args) {
        processFileData();
    }

}

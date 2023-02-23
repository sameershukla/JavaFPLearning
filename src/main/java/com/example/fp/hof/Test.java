package com.example.fp.hof;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

public class Test {

    static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        Function<String, String> add = x -> {
            System.out.println("1:"+x);
            return x + "Test";
        };

        Function<String, Consumer<String>> log = (x) -> new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("2:"+s);
                logger.info(s);
            }
        };
        Function<String, Consumer<String>> pipeline = log.compose(add);
        String data = "Data";
        pipeline.apply("data").accept(data);

    }
}

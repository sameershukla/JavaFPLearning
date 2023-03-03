package com.example.fp.composition.basic;

import com.example.fp.types.Tuple;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

/**
 * Consists of 4 functions, createUrl, Invoke Service, Process Response, outcome
 */
public class RestClientPipelineExample {

    private static Tuple<String, URL> createUrl(String inputUrl)  {
        try {
            return new Tuple<String, URL>(inputUrl, new URL(inputUrl));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Tuple<Integer, String> invokeApi(URL inputUrl) {
        //Call Service
        return new Tuple<>(200, "Success");
    }

    private static String processResponse(Tuple<Integer, String> response){
        if(response._1() == 200 && response._2().equals("Success")){
            return "Service Invocation Successfully";
        }
        return "Service Invocation Failed";
    }

    public static String invoke(String url){
        Function<String, Tuple<String, URL>> pipeline = RestClientPipelineExample:: createUrl;
        return pipeline
                .andThen(t -> invokeApi(t._2()))
                .andThen(t -> processResponse(t))
                .apply(url);
    }
}


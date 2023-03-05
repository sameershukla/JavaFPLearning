package com.example.fp.problems.restclient;

import com.example.fp.basics.types.Tuple;
import com.example.fp.basics.types.Unit;
import lombok.Getter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;
import java.util.function.Function;

public class FunctionalRestClientPipeline {

    @Getter
    class Response{
       public Boolean format;
       public String domain;
       public Boolean disposable;
       public Boolean dns;
       public Boolean whitelist;
    }

    private static HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static Function<String, Tuple<HttpClient, HttpRequest>> createRequest = (url) -> {
        return new Tuple<>(httpClient, HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build());
    };

    private static  HttpResponse<String> executeRequest(Tuple<HttpClient, HttpRequest> tuple){
        try {
            HttpResponse<String> response = tuple._1().send(tuple._2(), HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };

    private static Function<HttpResponse<String>, Unit> executeResponse(HttpResponse<String> response)  {
        System.out.println(response.statusCode() + "-" + response.body());
        return (t) -> Unit.unit();
    };

    public static void main(String[] args) {
        System.out.println("Enter EmailId :");
        String email = new Scanner(System.in).nextLine();
        if(email == null){
            throw new IllegalArgumentException("Email Cannot be Null");
        }
        String url = "https://www.disify.com/api/email/" + email;
        createRequest
                .andThen(FunctionalRestClientPipeline:: executeRequest)
                .andThen(FunctionalRestClientPipeline:: executeResponse)
                .apply(url);
    }


}

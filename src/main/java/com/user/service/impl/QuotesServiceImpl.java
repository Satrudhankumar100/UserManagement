package com.user.service.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.user.service.IQuotesService;


@Service
public class QuotesServiceImpl implements IQuotesService {



    public String getRandomQuotes() {
    	HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest instance
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://zenquotes.io/api/today"))
                .GET() // Default method is GET
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print response status code and body
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

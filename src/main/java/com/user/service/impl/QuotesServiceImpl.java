package com.user.service.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.dto.QuotesDTO;
import com.user.service.IQuotesService;


@Service
public class QuotesServiceImpl implements IQuotesService {



    public QuotesDTO getRandomQuotes() {
    	HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest instance
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://zenquotes.io/api/random"))
                .GET() // Default method is GET
                .build();
        
        
        

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            
         // Convert JSON string to List of QuoteDTO
            List<QuotesDTO> quotes = objectMapper.readValue(response.body(), new TypeReference<List<QuotesDTO>>() {});
            // Print response quotes
            System.err.println(quotes);
            return quotes.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

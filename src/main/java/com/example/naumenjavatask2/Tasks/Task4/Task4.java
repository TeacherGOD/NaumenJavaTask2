package com.example.naumenjavatask2.Tasks.Task4;




import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4 {
    public Task4() {

        try  {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new java.net.URI("https://httpbin.org/get"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            var  hosts = jsonNode.path("headers");
            String hostValue = jsonNode.path("headers").path("Host").asText();
            System.out.println("Host: " + hostValue);
        } catch (Exception e) {
            throw new RuntimeException("HTTP", e);
        }
    }

    public static void main(String[] args) {
        new Task4();
    }
}
package com.example.springcrudapp.request;

import com.example.springcrudapp.model.Address;
import com.example.springcrudapp.model.Customer;
import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.time.temporal.ChronoUnit.SECONDS;


public class HttpRequestNewApi {
    public static void main(String[] args) {
        runConcurrentTask();
    }

    private static void runConcurrentTask() {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        for (int i = 1; i <= 20; i++) {
            executor.submit(new Task());
        }
        executor.shutdown();
    }

    public static void decreaseAssetValue() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/asset/decrease"))
                    .timeout(Duration.of(5, SECONDS))
                    .PUT(HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void performGetRequest() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/customers/getAll"))
                    .timeout(Duration.of(5, SECONDS))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void performPostRequest() {
        Customer customer = new Customer();
        customer.setName("Adam");
        customer.setSurname("Pudzianowski");
        Address address = new Address();
        address.setBuildingNumber("7");
        address.setStreet("Nowowiejska");
        customer.setAddress(address);

        Gson gson = new Gson();
        String json = gson.toJson(customer);

        try {
            InputStream is = new ByteArrayInputStream(json.getBytes());

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/customers/add"))
                    .headers("Content-Type", "application/json")
                    .timeout(Duration.of(5, SECONDS))
                    .POST(HttpRequest.BodyPublishers.ofInputStream(() -> is))
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        HttpRequestNewApi.decreaseAssetValue();
    }
}



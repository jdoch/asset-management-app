package com.example.springcrudapp.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestOldApi {

    public static void main(String[] args) {
        performGetRequest();
    }

    private static void performGetRequest() {
        try {
            HttpURLConnection con = createHttpConnection();
            getResponseStatus(con);
            readResponse(con);
            con.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpURLConnection createHttpConnection() {
        HttpURLConnection con = null;
        try {
            URL url = new URL("http://localhost:8080/customers/getAll");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
        } catch (IOException e) {
            System.err.println("createHttpConnection: " + e.getMessage());
        }
        return con;
    }

    private static void getResponseStatus(HttpURLConnection con) throws IOException {
        int status = con.getResponseCode();
        System.out.println("RESPONSE STATUS: " + status);
    }

    private static void readResponse(HttpURLConnection con) {
        InputStreamReader streamReader = null;
        try {
            streamReader = createStreamReader(con);
            readContent(streamReader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreamReader(streamReader);
        }
    }

    private static InputStreamReader createStreamReader(HttpURLConnection con) throws IOException {
        var inputStream = con.getInputStream();
        return new InputStreamReader(inputStream);
    }

    private static void readContent(InputStreamReader streamReader) {
        try (BufferedReader in = new BufferedReader(streamReader)) {
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void closeStreamReader(InputStreamReader streamReader) {
        try {
            if (streamReader != null) {
                streamReader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

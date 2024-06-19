package com.example.springcrudapp;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class AssetServiceEndToEndTest {
    private static final String API_ROOT = "http://localhost:8080/asset";

    @Test
    public void whenGetAllAssetsThenOK(){
        final Response response = RestAssured.get(API_ROOT + "/getAll?pageNumber=0&pageSize=2");
        assertEquals(HttpStatus.OK.value(),response.getStatusCode());
    }
}

package com.icai.practicas.controller;

import com.icai.practicas.controller.ProcessController.DataRequest;
import com.icai.practicas.controller.ProcessController.DataResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.ResourceAccessException;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControllerE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testing_step1_legacy_then_ok() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> data = new LinkedMultiValueMap<String,String>();
        data.add("fullName","Sergio Cuenca Núñez");
        data.add("dni","28733194F");
        data.add("telefono","+34 645889302");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        //When
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //Then
        String expectedResult = ResponseHTMLGenerator.message1;
        then(result.getBody()).isEqualTo(expectedResult);
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testing_step1_legacy_then_ko() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> data = new LinkedMultiValueMap<String,String>();
        data.add("fullName","Sergio Cuenca Núñez");
        data.add("dni","749GR7820");
        data.add("telefono","+65430456");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        //When
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //Then
        String expectedResult = ResponseHTMLGenerator.message2;
        then(result.getBody()).isEqualTo(expectedResult);
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
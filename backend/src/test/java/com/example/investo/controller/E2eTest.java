package com.example.investo.controller;

import com.example.investo.model.Company;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class E2eTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll_success() throws JSONException {
        String response = this.restTemplate.getForObject("/company", String.class);

        //JSONAssert.assertEquals("[]", response, false);
        JSONAssert.assertEquals("[{id:101},{id:102},{id:103},{id:104}]", response, false);
    }
    @Test
    public void getById_success() {
        ResponseEntity<Company> company = this.restTemplate.getForEntity("/company/101", Company.class);

        assertTrue(company.getStatusCode().is2xxSuccessful());
        assertEquals("bookinga", company.getBody().getName());
    }
}

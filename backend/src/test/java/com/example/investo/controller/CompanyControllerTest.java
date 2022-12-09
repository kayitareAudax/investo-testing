package com.example.investo.controller;

import com.example.investo.model.Company;
import com.example.investo.service.CompanyService;
import com.example.investo.service.CompanyServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
public class CompanyControllerTest {
    @MockBean
    @Autowired
    private CompanyServiceImpl companyServiceMock;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_all_success() throws Exception {
        List<Company> companies = Arrays.asList(new Company(12, "Bookinga", 3000, 50, 15000),
                new Company(13, "TURA", 2000, 40, 200000));
        when(companyServiceMock.getCompanies()).thenReturn(companies);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/company")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc
                .perform(request)
                .andExpect(content().json("[{\"id\":12,\"name\":\"Bookinga\",\"shareValue\":3000,\"myShares\":50,\"companyTotalFunds\":15000},{\"id\":13,\"name\":\"TURA\",\"shareValue\":2000,\"myShares\":40,\"companyTotalFunds\":200000}]"))
                .andReturn();
    }
    @Test
    public void get_one_success() throws Exception{
        Company company=new Company(12, "Bookinga", 3000, 50, 15000);
        when(companyServiceMock.getCompany(12)).thenReturn(company);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/company/12")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc
                .perform(request)
                .andExpect(content().json("{\"id\":12,\"name\":\"Bookinga\",\"shareValue\":3000,\"myShares\":50,\"companyTotalFunds\":15000}")).
                andReturn();
    }
    @Test
    public void create_201() throws Exception {
        Company company=new Company();
        company.setId(1);
        company.setName("Bookinga");
        company.setCompanyTotalFunds(15000);
        company.setMyShares(50);
        company.setShareValue(3000);
        ResponseEntity.status(HttpStatus.CREATED).body(company);
        ResponseEntity<Company> response= ResponseEntity.status(HttpStatus.CREATED).body(company);
        when(companyServiceMock.saveCompany(company)).thenReturn(response);
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(company);
        mockMvc.perform(post("/company").contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isCreated());
    }
}

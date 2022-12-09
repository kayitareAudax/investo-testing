package com.example.investo.service;

import com.example.investo.model.Company;
import com.example.investo.repository.CompanyRepo;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplTest {
    @Mock
    private CompanyRepo companyRepoMock;
    @InjectMocks
    private CompanyServiceImpl companyService;

    @Test
    public void getAll() {
        when(companyRepoMock.findAll()).thenReturn(Arrays.asList(new Company("Bookinga", 3000, 50, 15000),
                new Company("TURA", 2000, 40, 200000), new Company("MINE", 1000, 30, 400000)));
        assertEquals(companyService.getCompanies().size(), 3);
    }

    @Test
    public void getOne() {
        Company company = new Company(12, "MINE", 1000, 30, 400000);
        when(companyRepoMock.findById(Long.valueOf(12))).thenReturn(Optional.of(company));
        assertEquals(companyService.getCompany(12).getName(), "MINE");
    }

    @Test
    public void delete_success() {
        Company company = new Company(12, "MINE", 1000, 10, 20000);
        when(companyRepoMock.findById(Long.valueOf(12))).thenReturn(Optional.of(company));
        assertTrue(companyService.deleteCompany(12).getStatusCode().is2xxSuccessful());
    }

    @Test
    public void add_success() {
        Company company = new Company("Ubumwe", 100, 20, 40000);
        when(companyRepoMock.save(company)).thenReturn(company);
        assertEquals(companyService.saveCompany(company).getBody().getName(), "Ubumwe");
    }

    @Test
    public void delete_404() {
        Company company = new Company(12, "MINE", 1000, 10, 20000);
        when(companyRepoMock.findById(Long.valueOf(12))).thenReturn(Optional.empty());
        ResponseEntity<?> deleteCompany = companyService.deleteCompany(12);
        assertTrue(companyService.deleteCompany(12).getStatusCode().is4xxClientError());
    }
}

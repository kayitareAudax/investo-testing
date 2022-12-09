package com.example.investo.service;

import com.example.investo.model.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    public List<Company> getCompanies();

    public Company getCompany(long id);

    public ResponseEntity<Company> saveCompany(Company company);

    public ResponseEntity<String> deleteCompany(long id);
}

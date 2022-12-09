package com.example.investo.service;

import com.example.investo.model.Company;
import com.example.investo.repository.CompanyRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Company> getCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public Company getCompany(long id) {
        Company company = companyRepo.findById(id).get();
        return company;
    }

    @Override
    public ResponseEntity<Company> saveCompany(Company company) {
        log.info("saving company");
        companyRepo.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyRepo.save(company));
    }

    @Override
    public ResponseEntity<String> deleteCompany(long id) {
        Optional<Company> findById = companyRepo.findById(id);
        if (findById.isPresent()) {
            Company company = companyRepo.findById(id).get();
            companyRepo.delete(company);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Company deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found");

    }
}

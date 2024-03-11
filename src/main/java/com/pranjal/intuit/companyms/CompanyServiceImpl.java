package com.pranjal.intuit.companyms;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;


import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Transactional
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        return companyRepository.findById(id).map(existingCompany -> {
            existingCompany.setDescription(company.getDescription());
            existingCompany.setName(company.getName());
            companyRepository.save(existingCompany);
            return true;
        }).orElseThrow(() -> new NoSuchElementException("Company with id " + id + " not found"));
    }

    @Override
    public void createCompany(Company company) {
        System.out.println(company);
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            throw new NoSuchElementException("Company with id " + id + " not found");
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Company with id " + id + " not found"));
    }

}

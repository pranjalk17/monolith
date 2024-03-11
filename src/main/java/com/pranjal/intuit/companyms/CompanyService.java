package com.pranjal.intuit.companyms;

import java.util.List;
import com.pranjal.intuit.companyms.Company;


public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);




}

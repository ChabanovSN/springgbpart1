package ru.chabanov.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chabanov.spring.model.Company;
import ru.chabanov.spring.repository.CompanyRepository;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
   private CompanyRepository companyRepo;

    @Override
    public List<Company> getAll() {
        return companyRepo.findAll();
    }

    @Override
    public Company get(Integer id) {
        return companyRepo.findCompanyById(id);
    }

    @Override
    public void save(Company company) {
             companyRepo.save(company);
    }

    @Override
    public void delete(Integer id) {
        companyRepo.delete(companyRepo.findCompanyById(id));
    }
}

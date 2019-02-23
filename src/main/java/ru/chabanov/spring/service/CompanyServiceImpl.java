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
    @Transactional(readOnly=true)
    public Company get(Integer id) {

        return companyRepo.getOne(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Company> getAll() {

        return companyRepo.findAll();
    }

    @Override
    @Transactional
    public void save(Company company) {

        companyRepo.save(company);
    }

    @Override
    @Transactional
    public void remove(Company company) {

        companyRepo.delete(company);
    }

}

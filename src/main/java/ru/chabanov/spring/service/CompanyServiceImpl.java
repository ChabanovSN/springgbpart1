package ru.chabanov.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chabanov.spring.model.Company;
import ru.chabanov.spring.model.Role;
import ru.chabanov.spring.repository.CompanyRepository;
import ru.chabanov.spring.repository.RoleRepository;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    // Имя роли по умолчанию
    private static final String DEFAULT_ROLE_NAME="user";

    @Autowired
   private CompanyRepository companyRepo;
   @Autowired
   private RoleRepository roleRepo;
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
        Role role = roleRepo.findByName(DEFAULT_ROLE_NAME);
        // Установка роли для автора
       company.setRole(role);
        // Сохранение автора
        companyRepo.save(company);
    }

    @Override
    @Transactional
    public void remove(Company company) {

        companyRepo.delete(company);
    }
    @Override
    @Transactional(readOnly=true)
    public Company getByLogin(String login) {
       return companyRepo.findByLogin(login);

    }

}

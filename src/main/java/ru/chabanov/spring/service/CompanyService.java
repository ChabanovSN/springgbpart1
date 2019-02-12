package ru.chabanov.spring.service;

import ru.chabanov.spring.model.Company;

import java.util.List;

public interface CompanyService {
     List<Company> getAll();

     Company get(Integer id);

    void save(Company company);
    void delete(Integer id);
}

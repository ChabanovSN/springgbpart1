package ru.chabanov.spring.service;

import ru.chabanov.spring.model.Company;

import java.util.List;

public interface CompanyService {
    public Company get(Integer id);

    public List<Company> getAll();

    public void save(Company company);

    public void remove(Company company);
    public Company getByLogin(String login);
}

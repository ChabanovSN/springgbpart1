package ru.chabanov.spring.dao;

import ru.chabanov.spring.model.Ad;
import ru.chabanov.spring.model.Category;
import ru.chabanov.spring.model.Company;

public interface CRUD {
    Company findCompany(final Integer id);
    Ad findAd(final Integer id);
    Category findCategory(final Integer id);

    void merge(Company company, Ad ad, Category category);
    void persist(Company company, Ad ad, Category category);

}

package ru.chabanov.spring.service;

import ru.chabanov.spring.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category get(Integer id);

    void save(Category c);
    void delete(Integer id);
}

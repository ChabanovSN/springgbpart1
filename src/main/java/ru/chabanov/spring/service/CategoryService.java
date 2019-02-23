package ru.chabanov.spring.service;

import ru.chabanov.spring.model.Category;

import java.util.List;

public interface CategoryService {
    public Category get(Integer id);

    public List<Category> getAll();

    public void save(Category category);

    public void remove(Category category);
}

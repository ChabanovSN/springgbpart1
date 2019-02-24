package ru.chabanov.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chabanov.spring.model.Category;
import ru.chabanov.spring.repository.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    @Transactional(readOnly=true)
    public Category get(Integer id) {

        return categoryRepo.findOneCategory(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Category> getAll() {

        return categoryRepo.findAll();
    }

    @Override
    @Transactional
    public void save(Category category) {

        categoryRepo.save(category);
    }

    @Override
    @Transactional
    public void remove(Category category) {

        categoryRepo.delete(category);
    }

    }

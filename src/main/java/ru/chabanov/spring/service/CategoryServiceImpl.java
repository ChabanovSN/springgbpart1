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
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category get(Integer id) {
        return categoryRepo.findAdId(id);
    }


    @Override
    public void save(Category c) {
            categoryRepo.save(c);
    }

    @Override
    public void delete(Integer id) {
        categoryRepo.delete(categoryRepo.findAdId(id));
    }
}

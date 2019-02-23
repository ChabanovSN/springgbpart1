package ru.chabanov.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.chabanov.spring.model.Ad;

import java.util.List;

public interface AdService {
    public Page<Ad> getAll(Pageable pageable);

    public Ad get(Integer id);

    public void save(Ad article);

    public Page<Ad> getByCategoryId(Integer id, Pageable pageable);
}

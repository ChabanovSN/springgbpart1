package ru.chabanov.spring.service;

import ru.chabanov.spring.model.Ad;

import java.util.List;

public interface AdService {
    List<Ad> getAll();

    Ad get(Integer id);

    void save(Ad ad);
    void delete(Integer id);
}

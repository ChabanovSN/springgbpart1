package ru.chabanov.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.chabanov.spring.model.Ad;

import java.util.List;

public interface AdService {
    public Page<Ad> getAll(Pageable pageable);

    public Ad get(Integer id);

    @PreAuthorize("hasAuthority('user') or hasAuthority('admin')")
    public void save(Ad article);

    public Page<Ad> getByCategoryId(Integer id, Pageable pageable);

    @PreAuthorize("hasAuthority('admin')")
    void delete(Integer id);
    @PreAuthorize("hasAuthority('admin')")
    void update(Ad ad);
}

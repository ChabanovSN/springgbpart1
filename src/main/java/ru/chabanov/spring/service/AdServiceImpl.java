package ru.chabanov.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chabanov.spring.model.Ad;
import ru.chabanov.spring.repository.AdRepository;

import java.util.List;

@Service
@Transactional
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepo;

    @Override
    @Transactional(readOnly=true)
    public Page<Ad> getAll(Pageable pageable) {

        Page<Ad> articles = adRepo.findAll(pageable);

        return articles;
    }

    @Override
    @Transactional(readOnly=true)
    public Ad get(Integer id) {

        return adRepo.findById(id).get();
    }

    @Override
    @Transactional
    public void save(Ad article) {

        adRepo.save(article);
    }


    @Override
    @Transactional(readOnly=true)
    public Page<Ad> getByCategoryId(Integer id, Pageable pageable) {

        Page<Ad> ads = adRepo.findByCategoryId(id, pageable);
        return ads;
    }
}

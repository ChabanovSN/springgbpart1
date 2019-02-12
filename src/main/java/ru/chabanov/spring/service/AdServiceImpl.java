package ru.chabanov.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Ad> getAll() {
        return adRepo.findAll();
    }

    @Override
    public Ad get(Integer id) {
        return adRepo.findAdId(id);
    }

    @Override
    public void save(Ad ad) {
           adRepo.save(ad);
    }

    @Override
    public void delete(Integer id) {
        adRepo.delete(adRepo.findAdId(id));
    }
}

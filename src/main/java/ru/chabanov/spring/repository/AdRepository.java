package ru.chabanov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.chabanov.spring.model.Ad;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdRepository extends CrudRepository<Ad,Integer> {

    @Query("FROM Ad AS ads LEFT JOIN FETCH ads.categories LEFT JOIN FETCH ads.owner ")
    @Override
    List<Ad> findAll();

    @Query("FROM Ad AS ads LEFT JOIN FETCH ads.categories LEFT JOIN FETCH ads.owner  WHERE ads.id = :id ")
    Ad findAdId(@Param("id") Integer integer);
}

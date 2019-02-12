package ru.chabanov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.chabanov.spring.model.Ad;
import ru.chabanov.spring.model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {
    @Query("FROM Category AS c LEFT JOIN FETCH c.ads")
    @Override
    List<Category> findAll();

    @Query("FROM Category AS c LEFT JOIN FETCH c.ads  WHERE c.id = :id ")
    Category findAdId(@Param("id") Integer integer);
}

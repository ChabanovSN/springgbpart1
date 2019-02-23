package ru.chabanov.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.chabanov.spring.model.Ad;

@Repository
public interface AdRepository extends PagingAndSortingRepository<Ad, Integer> {

@Query("select  a FROM Ad a WHERE a.categories.id=:id")
 Page<Ad> findByCategoryId(@Param("id")Integer id, Pageable pageable);

}

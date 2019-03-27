package ru.chabanov.spring.repository;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.chabanov.spring.model.Company;

import java.util.List;
import java.util.Optional;


@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    public Company findByLogin(String login);

//      Company findCompanyById(Integer integer);
//     /// в чем разница этих подходов?
//      @Query("FROM Company AS c LEFT JOIN FETCH c.ads AS ads LEFT JOIN FETCH ads.categories ")
// //   @EntityGraph(value = "Graph.Company", type = EntityGraph.EntityGraphType.FETCH)
//      @Override
//      List<Company> findAll();


}

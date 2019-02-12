package ru.chabanov.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chabanov.spring.model.Ad;
import ru.chabanov.spring.model.Category;
import ru.chabanov.spring.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Service("crud")
@Repository
@Transactional
public class CRUDImpl implements CRUD {

    @PersistenceContext
    @Qualifier("transactionManager")
    private EntityManager entityManager;



    @Override
    public void merge(Company company, Ad ad, Category category) {
        if(company !=null) entityManager.merge(company);
        if(ad !=null) entityManager.merge(ad);
        if(category !=null) entityManager.merge(category);
    }

    @Override
    public void persist(Company company, Ad ad, Category category) {
        if(company !=null) entityManager.persist(company);
        if(ad !=null) entityManager.persist(ad);
        if(category !=null) entityManager.persist(category);
    }

    @Override
    public Ad findAd(Integer id) {
        if (id <=0) return null;
        List<Ad> resultList = entityManager.createQuery("SELECT  e FROM Ad e " +
                "left join fetch e.categories left join fetch e.owner t" +
                " WHERE e.id = :id", Ad.class)
                .setParameter("id", id)
                .setMaxResults(1).getResultList();
        if (resultList.isEmpty()) return null;
        return resultList.get(0);

    }

    @Override
    public Category findCategory(Integer id) {
        if (id <=0) return null;
        List<Category> resultList = entityManager.createQuery("SELECT e FROM Category e left join fetch e.ads  WHERE e.id = :id", Category.class)
                .setParameter("id", id)
                .setMaxResults(1).getResultList();
        if (resultList.isEmpty()) return null;
        return resultList.get(0);
    }

    @Override
    public List<Company> findAllCompany() {
       return entityManager.createNamedQuery("Company.findAllCompany",Company.class).getResultList();
    }

    @Override
    public List<Ad> findAllAds() {
        return entityManager.createNamedQuery("Ad.findAllAds",Ad.class).getResultList();
    }

    @Override
    public Company findCompany(final Integer id) {
        if (id <=0) return null;
        List<Company> resultList = entityManager.createQuery("SELECT e FROM Company e left join fetch e.ads WHERE e.id = :id", Company.class)
                .setParameter("id", id)
                .setMaxResults(1).getResultList();
        if (resultList.isEmpty()) return null;
        return resultList.get(0);

    }
}

package ru.chabanov.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.chabanov.spring.config.AppConfig;
import ru.chabanov.spring.dao.CRUD;
import ru.chabanov.spring.dao.CRUDImpl;
import ru.chabanov.spring.model.Ad;
import ru.chabanov.spring.model.Category;
import ru.chabanov.spring.model.Company;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Company company = new Company();
//        company.setAddress("Пушкино 5");
//        company.setDescription("Ля-ля-ля");
//        company.setName("Рога и копыта");
//        Ad ad = new Ad();
//        ad.setName("Рекламка");
//        ad.setOwner(company);
//        ad.setNumber("999-6666-33");
//        ad.setContent("Content.............");
//        Set<Ad> adSet = new HashSet<>();
//
//        Category category = new Category();
//        category.setName("show on TV");
//        Set<Category> categorySet = new HashSet<>();
//        categorySet.add(category);
//
//        ad.setCategories(categorySet);
//        adSet.add(ad);
//        company.setAds(adSet);
        CRUD crud = context.getBean("crud",CRUD.class);
//        crud.persist(company,ad,category);

   //     System.out.println(crud.findCompany(2));
        System.out.println(crud.findAd(2));

    }
}

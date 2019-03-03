package ru.chabanov.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {

        //возвращает корневую конфигурации приложения (сервисы и дао-уровень)
        return  new Class<?>[] {AppConfig.class};
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {

        //возвращает конфигураци сервлета(веб-уровень, который включает в себя контроллеры)
        return new Class<?>[]{DispatcherServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {

        //возвращает путь, на который мэппится данный сервлет
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {

        //создание фильтра кодировки, который позволит работать с русскими символами
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        //создание фильтра, который добавляет поддержку  HTTP методов(например,таких как PUT)
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();


        //для доступа к данным в отображении, которые передаются путем ленивой инициализации
        OpenEntityManagerInViewFilter openEntityManagerFilter = new OpenEntityManagerInViewFilter();
        openEntityManagerFilter.setEntityManagerFactoryBeanName("entityManagerFactory");
        return new Filter[]{characterEncodingFilter, httpMethodFilter, openEntityManagerFilter};
    }
    }

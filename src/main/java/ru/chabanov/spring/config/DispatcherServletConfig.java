package ru.chabanov.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.*;

import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
@ComponentScan("ru.chabanov.spring.web")
@Import(AppConfig.class)
public class DispatcherServletConfig implements WebMvcConfigurer {


    public void addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(localeChangeInterceptor());


    };



    @Bean("tilesViewResolver")
    public UrlBasedViewResolver setupViewTilesResolver(){
        UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    @Bean("tilesConfigurer")
    public TilesConfigurer tilesConfigurer(){

        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        //в сеттер передаются пути к XML-файлам, в которых описываются шаблоны
        tilesConfigurer.setDefinitions("/WEB-INF/views/layouts.xml","/WEB-INF/views/**/layouts.xml");
        return tilesConfigurer;

    }
    @Bean("messageSource")
    public ReloadableResourceBundleMessageSource messageSource(){

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("WEB-INF/i18n/messages","WEB-INF/i18n/application");
        return messageSource;
    }

    @Bean("localeChangeInterceptor")
    public LocaleChangeInterceptor localeChangeInterceptor(){

        LocaleChangeInterceptor localeChangeInterceptor= new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;

    }

    @Bean("localeResolver")
    public CookieLocaleResolver localeResolver(){

        CookieLocaleResolver localResolver = new CookieLocaleResolver();
        localResolver.setCookieName("locale");
        return localResolver;
    }


    public LocalValidatorFactoryBean validator(){

        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;

    }

    @Override
    public Validator getValidator(){

        return validator();
    }

//    @Bean
//    public InternalResourceViewResolver setupViewResolver(){
//
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//
//
//        return resolver;
//    }
}

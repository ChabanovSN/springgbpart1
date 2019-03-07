package ru.chabanov.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan("ru.chabanov.spring.web")
//@Import(AppConfig.class)
public class DispatcherServletConfig implements WebMvcConfigurer {


//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//             "classpath:/resources/",
//            "classpath:/static/" };
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
//    }
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//
//    }
//
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

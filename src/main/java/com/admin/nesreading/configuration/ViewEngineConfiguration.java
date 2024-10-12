package com.admin.nesreading.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ViewEngineConfiguration {
  @Bean
  ViewResolver thymeleafViewResolver() {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(templateEngine());
    viewResolver.setCharacterEncoding("UTF-8");
    viewResolver.setCache(false);
    return viewResolver;
  }

  @Bean
  SpringTemplateEngine templateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    Set<ITemplateResolver> resolvers = new HashSet<>();
    resolvers.add(pageTemplateResolver());
    resolvers.add(layoutTemplateResolver());
    templateEngine.setTemplateResolvers(resolvers);

    return templateEngine;
  }

  @Bean
  ITemplateResolver pageTemplateResolver() {
    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setPrefix("/templates/pages/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setCharacterEncoding("UTF-8");
    templateResolver.setCacheable(false);
    templateResolver.setOrder(0);
    templateResolver.setCheckExistence(true);

    return templateResolver;
  }

  @Bean
  ITemplateResolver layoutTemplateResolver() {
    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setPrefix("/templates/layouts/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setCharacterEncoding("UTF-8");
    templateResolver.setCacheable(false);
    templateResolver.setOrder(1);
    templateResolver.setCheckExistence(true);

    return templateResolver;
  }
}

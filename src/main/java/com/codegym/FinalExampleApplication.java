package com.codegym;


import com.codegym.formatter.CountryFormatter;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import com.codegym.service.impl.CityServiceImpl;
import com.codegym.service.impl.CountryServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


import java.util.Locale;

@SpringBootApplication
public class FinalExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalExampleApplication.class, args);
	}
	@Bean
	public CountryService countryService(){
		return new CountryServiceImpl();
	}

	@Bean
	public CityService cityService(){
		return new CityServiceImpl();
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("ValidationMessages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}


	@Configuration
	class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

		private ApplicationContext appContext;

		@Override
		public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			appContext = applicationContext;
		}

		@Override
		public void addFormatters(FormatterRegistry registry) {
			CountryService countryService = appContext.getBean(CountryService.class);
			Formatter countryFormatter = new CountryFormatter(countryService);
			registry.addFormatter(countryFormatter);
		}

	}

}

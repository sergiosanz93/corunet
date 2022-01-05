package com.ssanz.corunet;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class SergioSanzCorunetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SergioSanzCorunetApplication.class, args);
	}
	
    @PostConstruct
    public void init(){
      TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }

}

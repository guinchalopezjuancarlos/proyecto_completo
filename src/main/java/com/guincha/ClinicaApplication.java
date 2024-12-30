package com.guincha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.guincha.Model.User;
import com.guincha.Repository.UserRepository;



@SpringBootApplication
public class ClinicaApplication {
	   @Autowired
	    PasswordEncoder encoder;
	    
	    @Autowired
	    UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}
	   @Bean
	    public CommandLineRunner initData() {
	        return args -> {
	       
	            if (userRepository.findByEmail("jc@gmail.com")==null) {
	                User user = new User("Juan Carlos", "jc@gmail.com","$2y$12$WKTgxqj7didOTJkkBkKeTu3bun4vPaojTkRcYXY/CWF9HK2CUvfb2" ,
	                		User.Role.ADMIN);
	                userRepository.save(user);
	        }
	       
	    };
	    }
	   
	   @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedOrigins("http://localhost:4200") 
	                        .allowedMethods("GET", "POST", "PUT", "DELETE")
	                        .allowCredentials(true)
	                        .maxAge(3600);
	            }
	        };
	    }
}

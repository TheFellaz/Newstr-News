package com.example.Newsternews.WebConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {

    // Fix CORS Error
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
        .allowedMethods("GET","POST")
        .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept","Access-Control-Allow-Credentials")
        .allowCredentials(true)
        .allowedOrigins("http://localhost:3000");
    }
}

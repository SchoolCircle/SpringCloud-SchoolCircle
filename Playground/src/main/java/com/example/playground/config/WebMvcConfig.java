package com.example.playground.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("All")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Value("${images.file-path}")
//    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**").addResourceLocations("file:d:/file/pic2/");//帖子图片目录

    }

}

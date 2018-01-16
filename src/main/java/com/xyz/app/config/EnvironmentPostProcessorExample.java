package com.xyz.app.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 类: EnvironmentPostProcessorExample <br>
 * 描述: ${DESCRIPTION}<br>
 * 作者: gaoxugang <br>
 * 时间: 2018年01月16日 16:16
 */
@Component
public class EnvironmentPostProcessorExample implements EnvironmentPostProcessor {

    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment configurableEnvironment, SpringApplication springApplication) {
        Resource path = new ClassPathResource("config.yml");
        PropertySource<?> propertySource = loadYaml(path);
        try {
            System.out.println("PropertySource:"+new ObjectMapper().writeValueAsString(propertySource.getSource()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        configurableEnvironment.getPropertySources().addLast(propertySource);
    }

    private PropertySource<?> loadYaml(Resource path){
        if (!path.exists()){
            throw new IllegalArgumentException("Resource "+ path + "does not exist");
        }
        try {
            return this.loader.load("custom-resource", path, null);
        }catch (IOException ex){
            throw new IllegalStateException(
                    "Failed to load yaml configuration from " + path, ex);
        }
    }
}

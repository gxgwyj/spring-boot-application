package com.xyz.app.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 数据源配置
 * Created by Lenovo on 2018/1/6.
 */
@Configuration
public class DataSourceConfig {

    private static String MAPPER_PATH = "mybatis/mappers/**.xml";
    private static String BASE_PACKAGE = "com.xyz.app.dao";



    /**
     * 数据源配置
     * @return
     */
    @Bean(name = "datasource")
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * mybatis配置
     * @return
     * @throws IOException
     */
    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("datasource") DataSource dataSource) throws IOException {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));

        return sqlSessionFactoryBean;
    }

    /**
     * mybatis自动扫描配置
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(BASE_PACKAGE);
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");

        return mapperScannerConfigurer;

    }
}

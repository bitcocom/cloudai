package org.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

// root-context.xml
@Configuration
@MapperScan(basePackages = "org.example.repository")
public class RootConfig {

    @Bean
    public HikariConfig hikariConfig(){
         HikariConfig config=new HikariConfig();
         config.setDriverClassName("com.mysql.cj.jdbc.Driver");
         config.setJdbcUrl("jdbc:mysql://localhost:3306/ai");
         config.setUsername("root");
         config.setPassword("12345");
         return  config;
    }

    @Bean
    public DataSource dataSource(){
        return new HikariDataSource(hikariConfig()); // Connection Pool
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis-config/mapper/**.xml"));
        return sqlSessionFactoryBean.getObject(); // SqlSessionFactory
    }

}

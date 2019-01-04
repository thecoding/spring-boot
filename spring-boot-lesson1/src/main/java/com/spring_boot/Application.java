package com.spring_boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@SpringBootApplication
@MapperScan("com.spring_boot.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean(name = "primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource(){
		return (DataSource) DataSourceBuilder.create().build();
	}


	@Bean(name = "secondDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.second")
	public DataSource secondDataSource(){
		return (DataSource) DataSourceBuilder.create().build();
	}

	@Bean(name="primaryDataTemplate")
	@Primary
	public JdbcTemplate primaryJdbcTemplate(@Autowired @Qualifier("primaryDataSource")DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean(name="secondJdbcTemplate")
	public JdbcTemplate secondJdbcTemplate(@Autowired @Qualifier("secondDataSource")DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
}


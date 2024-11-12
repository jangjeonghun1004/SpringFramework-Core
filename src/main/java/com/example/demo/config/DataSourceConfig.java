package com.example.demo.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import javax.sql.DataSource;

//@Configuration
public class DataSourceConfig {
    // 개발 환경용 DB 설정
//    @Bean
//    @Profile("dev")
//    public DataSource devDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }

    // 테스트 환경용 DB 설정
//    @Bean
//    @Profile("test")
//    public DataSource testDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/test_db");
//        dataSource.setUsername("test_user");
//        dataSource.setPassword("test_password");
//        return dataSource;
//    }

    // 운영 환경용 DB 설정
//    @Bean
//    @Profile("prod")
//    public DataSource prodDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/prod_db");
//        dataSource.setUsername("prod_user");
//        dataSource.setPassword("prod_password");
//        return dataSource;
//    }
}

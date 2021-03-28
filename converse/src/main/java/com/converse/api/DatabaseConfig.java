package com.converse.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //dataSource.setUrl("jdbc:mysql://google/<converse>?cloudSqlInstance=<valiant-vault-30:us-east4:>&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=<root>&password=<root>");
        dataSource.setUrl("jdbc:mysql://localhost:3306/converse");
        dataSource.setUsername( "nahara" );
        dataSource.setPassword( "root" );
        return dataSource;
    }
}
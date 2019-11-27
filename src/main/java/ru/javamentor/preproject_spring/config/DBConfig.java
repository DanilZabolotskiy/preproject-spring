package ru.javamentor.preproject_spring.config;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.javamentor.preproject_spring.util.DBHelper;

@Configuration
public class DBConfig {

    @Autowired
    DBHelper dbHelper;

    @Bean
    SessionFactory sessionFactory(){
        return dbHelper.getSessionFactory();
    }
}

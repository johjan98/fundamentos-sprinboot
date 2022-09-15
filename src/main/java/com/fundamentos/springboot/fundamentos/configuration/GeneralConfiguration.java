package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class) //Para habilitar la clase como un archivo de propiedades
public class GeneralConfiguration {

  @Value("${value.name}")     //This value come from resources/application.properties
  private String name;
  @Value("${value.last-name}")
  private String lastName;
  @Value("${value.random}")
  private String random;
  @Value("${jdbc.url}")
  private String jdbcUrl;
  @Value("${driver}")
  private String driver;
  @Value("${username}")
  private String userName;
  @Value("${password}")
  private String password;

  @Bean
  public MyBeanWithProperties function(){
    return new MyBeanWithPropertiesImplement(name, lastName, random);
  }

  //Configuración base de datos
  @Bean
  public DataSource dataSource(){
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName(driver);
    dataSourceBuilder.url(jdbcUrl);
    dataSourceBuilder.username(userName);
    dataSourceBuilder.password(password);
    return dataSourceBuilder.build();
  }
}

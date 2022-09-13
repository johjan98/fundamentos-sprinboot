package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class) //Para habilitar la clase como un archivo de propiedades
public class GeneralConfiguration {

  @Value("${value.name}")     //This value come from resources/application.properties
  private String name;

  @Value("${value.last-name}")
  private String lastName;

  @Value("${value.random}")
  private String random;

  @Bean
  public MyBeanWithProperties function(){
    return new MyBeanWithPropertiesImplement(name, lastName, random);
  }
}

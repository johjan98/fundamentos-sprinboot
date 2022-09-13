package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfiguration {

  @Bean
  public MyBean beanOperation(){
    return new MyBeanTwoImplement();
    //return new MyBeanImplement(); Acá se puede cambiar fácilmente la dependencia que se quiera inyectar.
  }

  @Bean
  public MyOperation myOperation(){
    return new MyOperationImplement();
  }

  @Bean
  public MyBeanWithDependency myOperationImplement(MyOperation myOperation){
    return new MyBeanWithDependencyImplement(myOperation);
  }
}

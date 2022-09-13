package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{

  private final String name;
  private final String lastName;
  private final String random;

  public MyBeanWithPropertiesImplement(String name, String lastName, String random) {
    this.name = name;
    this.lastName = lastName;
    this.random = random;
  }

  @Override
  public String function() {
    return name + " -- " + lastName + ": " + random;
  }
}

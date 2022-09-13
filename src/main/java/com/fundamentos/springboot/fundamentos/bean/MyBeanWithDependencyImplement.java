package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

  MyOperation myOperation;

  public MyBeanWithDependencyImplement(MyOperation myOperation) {
    this.myOperation = myOperation;
  }

  @Override
  public void printWithDependency() {
    int number = 1;
    System.out.println(myOperation.suma(number));
    System.out.println("Hello from MyBeanWithDependencyImplement");
  }
}
                 
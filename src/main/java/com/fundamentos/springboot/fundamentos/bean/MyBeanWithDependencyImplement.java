package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

  private final Log logger = LogFactory.getLog(MyBeanWithDependencyImplement.class);
  MyOperation myOperation;

  public MyBeanWithDependencyImplement(MyOperation myOperation) {
    this.myOperation = myOperation;
  }

  @Override
  public void printWithDependency() {
    int number = 1;
    logger.info(myOperation.suma(number));
    logger.info("Hello from MyBeanWithDependencyImplement");
  }
}
                 
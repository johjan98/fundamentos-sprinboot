package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanTwoImplement implements MyBean{

  private final Log logger = LogFactory.getLog(MyBeanTwoImplement.class);
  @Override
  public void print() {
    logger.info("Hello from MyBeanTwoImplement");
  }
}

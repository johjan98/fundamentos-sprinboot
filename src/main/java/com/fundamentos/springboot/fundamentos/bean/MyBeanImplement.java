package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanImplement implements MyBean{

  private final Log logger = LogFactory.getLog(MyBeanImplement.class);
  @Override
  public void print() {
    logger.info("Hello from MyBeanImplement");
  }
}

package com.fundamentos.springboot.fundamentos.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{

  private final Log logger = LogFactory.getLog(ComponentTwoImplement.class);
  @Override
  public void saludar() {
    logger.info("Hello world from second component");
  }
}

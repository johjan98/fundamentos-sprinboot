package com.fundamentos.springboot.fundamentos.bean;

import com.fundamentos.springboot.fundamentos.bean.MyOperation;

public class MyOperationImplement implements MyOperation {
  @Override
  public int suma(int number) {
    return number + 1;
  }
}

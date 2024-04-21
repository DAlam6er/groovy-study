package com.dmdev.lesson10;

public record Person(Integer id) {
  // для возможности использования в блоке if()
  public boolean asBoolean() {
    return id > 10;
  }

  // для возможности использования в блоке switch()
  public boolean isCase(Object switchValue) {
    System.out.println("invoke isCase: " + switchValue);
    return false;
  }
}

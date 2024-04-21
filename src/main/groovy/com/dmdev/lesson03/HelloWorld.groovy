package com.dmdev.lesson03

class HelloWorld {
//    private by default
  Integer intValue = 13
//    @PackageScope — analog to java "package-private aka default"
  static void main(String[] args) {
    String value = "Hello World"
    println value
    println new HelloWorld().intValue
  }
}

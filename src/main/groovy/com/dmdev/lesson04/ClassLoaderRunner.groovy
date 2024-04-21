package com.dmdev.lesson04

import java.sql.DriverManager

class ClassLoaderRunner {
  static void main(String[] args) {
    String value = "Hello World"
    Class<String> clazz = value.getClass()

    assert clazz == String.class
    println clazz.getClassLoader()
    // null (Boostrap ClassLoader) - встроен в JVM - критически важные - сразу загружаются в память - parent всех Classloaders

    println DriverManager.class.getClassLoader()
    // jdk.internal.loader.ClassLoaders$PlatformClassLoader - lazy, по требованию
    println ClassLoaderRunner.class.getClassLoader()
    // jdk.internal.loader.ClassLoaders$AppClassLoader (System) - загружает все классы из -classpath
  }
}

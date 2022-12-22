package com.dmdev

import java.sql.DriverManager

class HelloWorld {
//    @PackageScope — analog to java "package-private"
    static void main(String[] args) {
        String value = "Hello World"
        println value

        Class<String> clazz = value.getClass()
        assert clazz == String.class
        println clazz.getClassLoader()
        println DriverManager.class.getClassLoader()
        println HelloWorld.class.getClassLoader()
    }
}

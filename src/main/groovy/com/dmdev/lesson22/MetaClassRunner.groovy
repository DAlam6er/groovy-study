package com.dmdev.lesson22

import com.dmdev.lesson17.Student
import org.codehaus.groovy.runtime.DefaultGroovyMethods

/**
 * Метакласс - дополнительный объект, который есть у каждого groovy-объекта
 * (в том числе объекта класса Class)
 */
class MetaClassRunner {
  static void main(String[] args) {
    // продемонстрируем, как добавить в CustomMetaClass
    // какие угодно методы из каких угодно классов
    def customMetaClass = new CustomMetaClass()
    // попробуем добавить метод println в CustomMetaClass
//        println "Hello"

    // первый аргумент - это имя метода, который мы хотим получить
    // последующие аргументы - это ТИПЫ АРГУМЕНТОВ самого метода (Object self, Object value)
    def method = DefaultGroovyMethods.getMethod("println", Object, Object)

    // так можно добавлять сколько угодно методов из любых классов
    customMetaClass.methods.put("println", method)

    // Вызов добавленного метода
    // у каждого Groovy-объекта, проходящего через MOP, есть метакласс
    // в нем осуществляется поиск метода (в нашем случае упрощенный - по ключу - названию метода)
    def printlnMethod = customMetaClass.methods.get("println")

    def student = new Student()

    // первый аргумент - это dummy-объект (никак не влияет)
    // это объект, у которого вызывают метод println
    // последующие аргументы - это аргументы метода println
    //      Object self - объект класса, у которого был вызван println
    //      Object value - то, что передали внутрь println
    printlnMethod.invoke(student, student, "Test 2")  // student.println("Test 2")

    // MetaClassImpl - дефолтный метакласс
    println student.metaClass
    println student.metaClass.methods
    println student.metaClass
    println "---------------------"

    //ExpandoMetaClass - наследник MetaClassImpl
    // позволяет динамически в runtime добавлять новые методы и поля
    // Map<MethodKey, MetaMethod> expandoMethods
    // Map<String, MetaProperty> expandoProperties
    student.metaClass.abc = "Test property"
    // все новые методы - это тоже поля, но в качестве типа данных используются closure
    student.metaClass.test = {
      println "It's a new method"
    }
    println student.abc
    student.test() // student.test.call()
    println student.metaClass

    // у объекта класса Class тоже есть метакласс
    student.class.metaClass.newMethod = { int value ->
      println "New method in class Student, $value"
    }

//        student.newMethod(28)  //groovy.lang.MissingMethodException
    // у новых объектов класса Student добавленный метод будет
    new Student().newMethod(28) // New method in class Student, 28

    // ProxyMetaClass - редко используется - interceptor
    // позволяет внедриться до или после вызова метода,
    // с целью залогировать или подкрутить что-то
  }
}

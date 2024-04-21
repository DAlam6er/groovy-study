package com.dmdev.lesson17


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import groovy.transform.builder.Builder

@ToString
@TupleConstructor
@EqualsAndHashCode
//@Canonical
//@Immutable
@Builder
//@Slf4j
//@Mixin(WithId.class)
class Student implements WithId {
  String firstName
  String lastName
  Integer age

  static void main(String[] args) {
    builder()
        .lastName("Ivanov")
        .firstName("Ivan")
        .build()
  }

  // зарезервированный метод, вызывается, если метод у объекта не найден
  def getAt(Integer index) {
    if (index == 0) {
      return firstName
    } else if (index == 1) {
      return lastName
    } else if (index == 2) {
      return age
    }
  }

  // зарезервированный метод, вызывается, если свойство у объекта не найдено
  // возвращает некоторое дефолтное значение
  def methodMissing(String name, Object arguments) {
    println "missing method $name is invoked: $arguments"

    if (name.startsWith("findBy")) {
      // spring-data
      def field = name - 'findBy'
      def fieldValue = this."$field"
//        println "SELECT * FROM Student WHERE $field = ${arguments[0]}"
      println "SELECT * FROM Student WHERE $field = $fieldValue"
    }
  }

  def propertyMissing(String name) {
    println "missing property $name"
    "default value"
  }

  def getInfo() {
    Closure closure = {
      println thisObject  // == this (Student.class)
      println owner       // == Student.class
      println delegate    // == owner
      Closure second = {
        println thisObject
        println owner
        println delegate
      }
      second() // вывод на консоль
    }
    closure // return
  }
}

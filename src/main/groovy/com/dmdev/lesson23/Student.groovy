package com.dmdev.lesson23

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor // конструкторы на все случаи жизни
class Student {
  String firstName
  String lastName
  Integer age

  /**
   * Вызывается через метакласс
   */
  def methodMissing(String name, Object arguments) {
    println "missing method $name is invoked: $arguments"
    def field = name - 'findBy'
    def fieldValue = this."$field"
    //println "select * from Student where $field = ${arguments[0]}"
    println "select * from Student where $field = $fieldValue"
  }

  def propertyMissing(String name) {
    println "missing property $name"
    "default value"
  }
}

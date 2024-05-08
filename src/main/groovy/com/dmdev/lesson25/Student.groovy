package com.dmdev.lesson25

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

  def getInfo() {
    Closure closure = {
      println thisObject // == this Student$_getInfo_closure1@14028087
      println owner // внешний класс - экземпляр класса Student Student$_getInfo_closure1@cecf639
      println delegate // == owner Student$_getInfo_closure1@7ce69770

      Closure second = { // declaration begin
        println thisObject // Student$_getInfo_closure1@268f106e
        println owner    // Student$_getInfo_closure1@6e9a5ed8
        println delegate // Student$_getInfo_closure1@6e9a5ed8
      } // declaration end
      // здесь может быть любой код, в котором мы можем подкрутить delegate и resolveStrategy
      // для того, чтобы все поля и методы, к которым мы обращаемся внутри Closure
      // относились совсем к другому объекту
      second() // execution
    }
    closure
  }
}

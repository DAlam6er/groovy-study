package com.dmdev.lesson17

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor // конструкторы на все случаи жизни
class Student {
  String firstName
  String lastName
  Integer age

  // метод используется при множественном присваивании: def (fn, ln, age) = student2
  def getAt(Integer index) {
    if (index == 0) {
      return firstName
    } else if (index == 1) {
      return lastName
    } else if (index == 2) {
      return age
    }
  }
}

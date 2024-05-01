package com.dmdev.lesson18.trait

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor // конструкторы на все случаи жизни
class Student implements WithId {
  String firstName
  String lastName
  Integer age
}

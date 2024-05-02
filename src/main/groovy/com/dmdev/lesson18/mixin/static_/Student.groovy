package com.dmdev.lesson18.mixin.static_

import groovy.transform.TupleConstructor

@TupleConstructor // конструкторы на все случаи жизни
@Mixin(WithId) // примесь, deprecated, т.к. есть traits
class Student {
  String firstName
  String lastName
  Integer age
}

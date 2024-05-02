package com.dmdev.lesson18.mixin.static_

class OopRunner {
  static void main(String[] args) {
    def student1 = new Student(firstName: "Petr", lastName: "Petrov", age: 18)
    student1.setId(666)
    assert student1.validateId() // true
  }
}

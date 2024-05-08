package com.dmdev.lesson24

import com.dmdev.lesson17.Student

@Category(Student.class) // какой класс хотим изменить
class DefaultStudentMethods {

  def testStr() {
    // можем обращаться к полям, словно используем this
    println "$age, $firstName"
  }

  // первый параметр - объект, у которого был вызван метод
  static def anotherMethod(Student self, String value) {
    println "$self, args: $value"
  }
}

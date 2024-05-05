package com.dmdev.lesson24

import com.dmdev.lesson17.Student

class CategoryRunner {
  static void main(String[] args) {
    def student = new Student(age: 18, firstName: "Ivan")

    // все изменения, которые добавляются в DefaultStudentMethods не появятся до тех пор,
    // пока мы не попросим
    // по сути в методе use происходит добавление всех методов из Category класса в metaClass
    // всех объектов внутри блока Closure
    // После выхода из блока Closure - удаляются из metaClass
    use(DefaultStudentMethods.class) {
      student.testStr()
      student.anotherMethod("Test arg")
    }
  }
}

package com.dmdev.lesson18.trait

class OopRunner {
  static void main(String[] args) {
    def student1 = new Student(firstName: "Petr", lastName: "Petrov", age: 18, id: 666)
    println student1
    println "----------------------"

    // coercion (принуждение) объект как массив его аргументов
    Student student2 = ['Sveta', 'Svetikova', 30]
    println student2

    println "----------------------"
    // firstName = Petr
    // lastName = Petrov
    // age = 18
    // com_dmdev_lesson18_trait_WithId__id=666
    // class=class com.dmdev.lesson18.trait.Student
    // id = 666
    student1.properties.each { println it }
  }
}

package com.dmdev.lesson17

class OopRunner {
  static void main(String[] args) {
    def student = new Student()
    student.firstName = "Ivan"  // setFirstName()
    println student.firstName   // getFirstName()
    println student['firstName']
    println student.'firstName'
    println student.@firstName  // not recommended - direct access to field

    println "----------------------"
    def student1 = new Student(firstName: "Petr", lastName: "Petrov", age: 18)
    println student1

    println "----------------------"
    student1.properties.each { println it }

    println "----------------------"
    // coercion (принуждение) объект как массив его аргументов
    Student student2 = ['Sveta', 'Svetikova', 30]
    println student2

    println "----------------------"
    // множественное присваивание с помощью метода getAt()
    def (fn, ln, age) = student2
    println fn
    println ln
    println age

    // маппинг
    assert [student1, student2].collect { it.firstName } == ['Petr', 'Sveta']
    assert [student1, student2]*.firstName == ['Petr', 'Sveta']
    assert [student1, student2].firstName == ['Petr', 'Sveta']
  }
}

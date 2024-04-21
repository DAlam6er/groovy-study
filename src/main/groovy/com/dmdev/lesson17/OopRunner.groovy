package com.dmdev.lesson17

class OopRunner {
  static void main(String[] args) {
    def student = new Student()
    student.firstName = "Ivan"  // setFirstName
    println student.firstName   // getFirstName
    println student['firstName']
    println student.'firstName'
    println student.@firstName  // not recommended - direct access to field

    def student1 = new Student(firstName: "Petr", lastName: "Petrov", age: 18, id: 666)
    println student1

    student1.properties.each { println it }

    Student student2 = ['Sveta', 'Svetikova', 30]
    println student2

    // множественное присваивание
    def (fn, ln, age) = student2
    println fn
    println ln
    println age

    // маппинг
    assert [student1, student2].collect { it.firstName } == ['Petr', 'Sveta']
    assert [student1, student2]*.firstName == ['Petr', 'Sveta']
    assert [student1, student2].firstName == ['Petr', 'Sveta']

    // Привнесем в класс String новый функционал из класса OopRunner
    // весь функционал, который принадлежит классу OopRunner,
    // т.е. все его статические методы, будут добавлены в класс String
    String.mixin(OopRunner.class)

    "Ivan".printStr()   // It's mixin Ivan
  }

  // тот класс, в который привносим новый функционал идет первым параметром
  // и именуется как self
  static def printStr(String self) {
    println "It's mixin $self"
  }
}

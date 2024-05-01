package com.dmdev.lesson18.mixin

class OopRunner {
  static void main(String[] args) {
    def student1 = new Student(firstName: "Petr", lastName: "Petrov", age: 18, id: 666)
    println student1
    println "----------------------"

    // class = ... id = ... firstName = ... lastName = ... age = ...
    student1.properties.each { println it }
    println "----------------------"

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

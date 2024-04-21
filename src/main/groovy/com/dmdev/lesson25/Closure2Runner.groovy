package com.dmdev.lesson25

import com.dmdev.lesson17.Student

class Closure2Runner {
  static void main(String[] args) {
    Closure closure = {
      firstName = "Sveta"
    }
    println closure.thisObject
    println closure.owner
    println closure.delegate

    def student = new Student("Ivan", "Ivanov", 29)
    println "Before delegating:"
    println student

    // Способ 1
//        closure.delegate = student
//        closure.resolveStrategy = Closure.DELEGATE_FIRST
//        closure()

    // Способ 2
    student.with closure

    println "After delegating:"
    println student
    println "---------------------------------------------------------"

//        student.getInfo().call()
    student.getInfo()()
  }
}

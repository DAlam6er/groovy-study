package com.dmdev.lesson11

import com.dmdev.lesson10.Person

/**
 * В Java мы можем использовать следующие типы данных в switch:
 * <ul>
 *   <li>byte</li>
 *   <li>short</li>
 *   <li>int</li>
 *   <li>char</li>
 *   <li>String</li>
 *   <li>enum</li>
 * </ul>
 * В случае с Groovy мы можем дополнительно передавать:
 * <ul>
 *   <li>Class<?></li> - isInstance (можно не писать .class)
 *   <li>Pattern</li>
 *   <li>Closure</li>
 *   <li>Collection</li>
 * </ul>
 */
class SwitchRunner {
  static void main(String[] args) {
    // метод содержит вызов 8 различных методов
    // т.о. байткод класса будет содержать массив CallSite[] из 9 эл-тов
    int x = 12
    // switch statement
    switch (x) {
      case String:
        println 0                     // вызов 0-й
        break
      case 5:                         // equals ==
        println 1                     // вызов 1-й
        break
      case new Person(29):         // person.isCase(12) // вызов 2-й
        println 5 // вызов 3-й
        break
      case ~/\d+/:                   // pattern.matcher(12.toString()).matches()
        println 2 // вызов 4-й
        break
      case { it % 5 == 0 }:
        println 3                     // вызов 5-й
        break
      case [1, 3, 5, 8, 9]:
        println 4                     // вызов 6-й
        break
      default:
        println "None"                // вызов 7-й
        break
    }

    println '============================='

    // switch expression (since Groovy 4.0)
    println switch (x) {
      case String -> 'string'
      case 5 -> 'five'
      case new Person(29) -> 'person object'
      case ~/\d+/ -> 'some number'
      case {it % 5 == 0} -> 'some number multiple of 5'
      case [1, 3, 5, 8, 9] -> 'list of numbers 1, 3, 5, 8, 9'
      case null -> 'just a null'
      default -> "None"
    }

    // неявно вызывается метод isCase() у списка
    if (x in [1, 3, 6, 8, 12]) {
      println x // вызов 8-й
    }
  }
}

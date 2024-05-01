package com.dmdev.lesson12

class LoopsRunner {
  static void main(String[] args) {
    def list = [1, 2, 3, 4]
    // while / for
    for (int i = 0; i < list.size(); i++) {
      // some code
    }
    // Все нижеуказанные методы вызываются у утилитного класса DefaultGroovyMethods
    // 0..<list.size() - range [0;4) - открытый диапазон
    for (def i in 0..<list.size()) {
      println i // 0 1 2 3
    }

    println "------------------------------------------"
    // 0..list.size() - range [0;4] - закрытый диапазон
    for (i in 0..list.size()) {
      println i // 0 1 2 3 4
    }

    println "------------------------------------------"
    // for each - не путать с неявным вызовом isCase() в выражении if (x in [1, 3, 6, 8, 12]) { ... }
    for (value in list) {
      println value // 1 2 3 4 (элементы списка)
    }

    println "------------------------------------------"
    // с использованием closure
    // статический метод из утилитного класса DefaultGroovyMethods.class
    0.upto(list.size()) { value ->
      println value // 0 1 2 3 4
    }

    println "------------------------------------------"
    // с использованием closure
    // статический метод из утилитного класса DefaultGroovyMethods.class
    list.size().downto(0) { println it } // 4 3 2 1 0

    println "------------------------------------------"
    // range [0;4) - открытый диапазон
    // с использованием closure
    // статический метод из утилитного класса DefaultGroovyMethods.class
    list.size().times {
      println it // 0 1 2 3
    }

    println "------------------------------------------"
    // аналогичен 0.upto()
    // с использованием closure
    // статический метод из утилитного класса DefaultGroovyMethods.class
    0.step(5, 1) {
      println it // 0 1 2 3 4
    }

    // с изменённым шагом
    println "------------------------------------------"
    0.step(5, 2) {
      println it // 0, 2, 4
    }
  }
}

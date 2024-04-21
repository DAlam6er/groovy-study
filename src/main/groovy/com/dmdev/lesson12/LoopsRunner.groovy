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
      println i
    }

    println "------------------------------------------"
    // 0..list.size() - range [0;4] - закрытый диапазон
    for (i in 0..list.size()) {
      println i
    }

    println "------------------------------------------"
    // for each - не путать с неявным вызовом isCase()
    for (value in list) {
      println value
    }

    println "------------------------------------------"
    // closure
    // статический метод из DefaultGroovyMethods.class
    0.upto(list.size()) { value ->
      println value
    }

    println "------------------------------------------"
    // статический метод из DefaultGroovyMethods.class
    list.size().downto(0) { println it }

    println "------------------------------------------"
    // range [0;4) - открытый диапазон
    // статический метод из DefaultGroovyMethods.class
    list.size().times {
      println it
    }

    println "------------------------------------------"
    // аналогичен 0.upto()
    // статический метод из DefaultGroovyMethods.class
    0.step(5, 1) {
      println it
    }

    0.step(5, 2) {
      println it // 0, 2, 4
    }
  }
}

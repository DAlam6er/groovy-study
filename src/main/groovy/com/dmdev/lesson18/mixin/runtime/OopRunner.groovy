package com.dmdev.lesson18.mixin.runtime

/**
 * Такие mixins добавляются во время старта приложения, т.к. они глобальные для всего приложения
 * Невозможно добавить mixin для конкретного объекта
 */
class OopRunner {
  static void main(String[] args) {
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

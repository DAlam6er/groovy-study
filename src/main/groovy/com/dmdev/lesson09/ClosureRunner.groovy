package com.dmdev.lesson09

import java.util.function.Function
import java.util.stream.Stream

class ClosureRunner {
  static void main(String[] args) {
    println "В Java: "
    Stream.of(1, 2, 3, 4)
        .map(value -> value + value)
        .map(String::valueOf)
        .forEach(System.out::println)

    Function<Integer, Integer> func = value -> value + value
    def functionResult = func.apply(5)
    println functionResult // 10
    println "----------------------"
    Stream.of(1, 2, 3, 4)
        .map(func)
        .map(String::valueOf)
        .forEach(System.out::println)
    println "----------------------"

    println "В Groovy: "
    Closure groovyClosure1 = value -> value + value
    // можем вызывать closure, передавая ему значение
    def groovyResult1 = groovyClosure1.call(5)
    println groovyResult1 // 10
    println "----------------------"
    // последняя строка возвращается в качестве результата
    Closure groovyClosure2 = { value -> value + value }
    def groovyResult2 = groovyClosure2.call(5)
    println groovyResult2 // 10
    println "----------------------"
    // опускаем параметр, используя зарезервированное ключевое слово it
    Closure myClosure = { it + it }
    // опускаем вызов call
    def result = myClosure(5)
    println result // 10
    println "----------------------"
    Stream.of(1, 2, 3, 4)
        .map(myClosure)
        .map(String.&valueOf) // возвращает closure
        .forEach(System.out::println)
    println "----------------------"

    // дефолтные параметры для closure
    Closure closureWithDefaultParameter = { it = 78 -> it + it }
    println closureWithDefaultParameter() // 156
    println "----------------------"

    int x = 10
    check(x > 0, { println x })

    int y = 20
//        check(y > x, { println(++x) })
//        check(y > x) { println(++x) }
    // теперь check() стал похож на if(condition) { блок_кода }
    check(y > x) {
      println(++x)
    }
  }

  // функция check - функция высшего порядка
  static def check(boolean condition, Closure closure) {
    if (condition) {
      closure()
    }
  }
}

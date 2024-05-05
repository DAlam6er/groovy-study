package com.dmdev.lesson21

/**
 * MOP = Meta Object Protocol
 * CallSite-прослойка и есть MOP. Через неё вызываются методы
 * В Groovy никогда явно не вызываем метод у того класса, у которого его вызвали
 */
class MopRunner {
  // в байткоде будет проксирование метода println() через метакласс:
  // CallSite[] var1 = $getCallSiteArray()
  // var1[0].callStatic(MopRunner.class, "Hello")
  static void main(String[] args) {
    println "Hello"
  }
}

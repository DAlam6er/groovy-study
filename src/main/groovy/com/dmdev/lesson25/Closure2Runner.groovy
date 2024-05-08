package com.dmdev.lesson25

class Closure2Runner {
  static void main(String[] args) {
    Closure closure = {
      firstName = "Sveta"
    }
    // 3 основных поля Closure
    // указывает на объект, к которому мы обращаемся, используя ссылку this
    // в статическом методе main указывает на объект класса Class
    println "thisObject: ${closure.thisObject}"
    // Обращаемся к объекту, где определили Closure
    println "owner: ${closure.owner}"
    // То же, что и owner, используется, чтобы вручную можно было поменять. Используется в DSL
    println "delegate: ${closure.delegate}"

    def student = new Student("Ivan", "Ivanov", 29)
    println "Before delegating:"
    println student

    // Паттерн делегирования: все запросы, которые приходят на closure, делегируем объекту student
    // Способ 1
    /*closure.delegate = student
    // возможные варианты resolveStrategy: OWNER_FIRST, DELEGATE_FIRST, OWNER_ONLY, DELEGATE_ONLY, TO_SELF (ищем только в Closure)
    // ключевой механизм в понимании того, к какому scope относится блок кода нашего Closure и к кому он будет перенаправлять запросы
    closure.resolveStrategy = Closure.DELEGATE_FIRST // чтобы искать property в объекте Student
    closure()*/

    // Способ 2
    student.with closure // заменяет 3 строки

    println "After delegating:"
    println student
    println "---------------------------------------------------------"

    student.getInfo()() // == student.getInfo().call()
  }
}

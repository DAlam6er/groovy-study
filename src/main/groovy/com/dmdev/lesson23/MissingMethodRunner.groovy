package com.dmdev.lesson23

/**
 * Если метод не был найден у объекта, то будет вызван invokeMissingMethod()
 * Если поле не было найдено у объекта, то будет вызвано метод invokeMissingProperty()
 */
class MissingMethodRunner {
  static void main(String[] args) {
    def student = new Student(age: 45)
//        student.test()
    println student.abc

    // пройдя через MOP Groovy использует propertyMissing для того,
    // чтобы спроксировать запрос по значению ключа в map.get("значение_ключа")
    def map = ["1": 11, "2": 22, "abc": 34] // LinkedHashMap
    println map."1" // обращаемся к свойству LinkedHashMap map.get("1") в propertyMissing()
    println map.abc

    // использование methodMissing на примере spring-data, StudentRepository
    // можно строить динамические запросы
    student.findByAge(90)
  }
}

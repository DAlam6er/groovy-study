package com.dmdev.lesson23

import com.dmdev.lesson17.Student

class MissingMethodRunner {
    static void main(String[] args) {
        def student = new Student(age: 45)
//        student.test()
        println student.abc

        // пройдя через MOP Groovy использует propertyMissing для того,
        // чтобы спроксировать запрос по значению ключа в map.get("значение_ключа")
        def map = ["1": 11, "2": 22, "abc" : 34] // LinkedHashMap
        println map."1" // обращаемся к свойству LinkedHashMap
        println map.abc

        // использование methodMissing на примере spring-data, StudentRepository
        student.findByAge(90)
    }
}

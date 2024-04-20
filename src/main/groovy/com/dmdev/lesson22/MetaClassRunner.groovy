package com.dmdev.lesson22

import com.dmdev.lesson17.Student
import org.codehaus.groovy.runtime.DefaultGroovyMethods

import java.lang.reflect.Method

class MetaClassRunner {
    static void main(String[] args) {
        // продемонстрируем, как добавить в CustomMetaClass
        // какие угодно методы из каких угодно классов
        def customMetaClass = new CustomMetaClass()
        // попробуем добавить метод println в CustomMetaClass
//        println "Hello"

        // первый аргумент - это имя метода, который мы хотим получить
        // последующие аргументы - это ТИПЫ АРГУМЕНТОВ самого метода (Object self, Object value)
        Method method = DefaultGroovyMethods.class.getMethod("println", Object.class, Object.class)

        // так можно добавлять сколько угодно методов из любых классов
        customMetaClass.methods.put("println", method)

        // Вызов добавленного метода
        // у каждого Groovy-объекта, проходящего через MOP, есть метакласс
        // в нем осуществляется поиск метода (в нашем случае упрощенный - по ключу - названию метода)
        def printlnMethod = customMetaClass.methods.get("println")

        def student = new Student()

        // первый аргумент - это dummy-объект (никак не влияет)
        // это объект, у которого вызывают метод println
        // последующие аргументы - это аргументы метода println
        //      Object self - объект класса, у которого был вызван println
        //      Object value - то, что передали внутрь println
        printlnMethod.invoke(student, student, "Test 2")  // student.println("Test 2")

        println student.metaClass  // MetaClassImpl

        student.metaClass.abc = "Test property"
        student.metaClass.test = {
            println "It's a new method"
        }
        println student.abc
        student.test()

        println student.metaClass  //ExpandoMetaClass

        student.class.metaClass.newMethod = { int value ->
            println "New method in class Student, $value"
        }

//        student.newMethod(28)  //groovy.lang.MissingMethodException
        new Student().newMethod(28) // New method in class Student, 28
    }
}

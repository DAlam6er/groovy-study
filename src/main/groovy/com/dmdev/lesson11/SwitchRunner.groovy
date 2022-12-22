package com.dmdev.lesson11

import com.dmdev.lesson10.Person

class SwitchRunner {
    static void main(String[] args) {
        // метод содержит вызов 8 различных методов
        // т.о. байткод класса будет содержать массив CallSite[] из 9 эл-тов
        int x = 12
        // byte, short, int, char, String, enum
        switch (x) {
            case String:        // isInstance
                println 0 // вызов 0-й
                break
            case 5:             // equals ==
                println 1 // вызов 1-й
                break
            case new Person(29):    // person.isCase(12) // вызов 2-й
                println 5 // вызов 3-й
                break
            case ~/\d+/:        // pattern.matcher(12.toString()).matches()
                println 2 // вызов 4-й
                break
            case { it % 5 == 0 }:
                println 3 // вызов 5-й
                break
            case [1, 3, 5, 8, 9]:
                println 4 // вызов 6-й
                break
            default:
                println "None" // вызов 7-й
                break
        }

        // неявно вызывается метод isCase() у списка
        if (x in [1, 3, 6, 8, 12]) {
            println x // вызов 8-й
        }
    }
}

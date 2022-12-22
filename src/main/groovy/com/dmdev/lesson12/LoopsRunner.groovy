package com.dmdev.lesson12

class LoopsRunner {
    static void main(String[] args) {
        def list = [1, 2, 3, 4]
//        for (int i = 0; i < list.size(); i++) {// some code}
        // Все нижеуказанные методы вызываются у утилитного класса DefaultGroovyMethods
        // 0..<list.size() - range [0;4)
        // 0..list.size() - range [0;4]
        for (i in 0..<list.size()) {
            println i
        }

        println "------------------------------------------"

        for (i in 0..list.size()) {
            println i
        }

        println "------------------------------------------"

        for (value in list) {
            println value
        }

        println "------------------------------------------"

        0.upto(list.size()) { value ->
            println value
        }

        println "------------------------------------------"

        list.size().downto(0) { println it}

        println "------------------------------------------"

        list.size().times {
            println it
        }

        println "------------------------------------------"

        0.step(5, 2) {
            println it
        }
    }
}

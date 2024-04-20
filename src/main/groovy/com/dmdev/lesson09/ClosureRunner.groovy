package com.dmdev.lesson09


import java.util.stream.Stream

class ClosureRunner {
    static void main(String[] args) {
//        Function<Integer, Integer> func = value -> value + value
//        def result = func.apply(5)
//        println result + "\n"

//        Closure closure = value -> value + value
//        Closure closure = {value -> value + value}
        Closure closure = { it + it }
//        def result = closure.call(5)
        // опускаем вызов call
        def result = closure(5)
        println result + "\n"

        Stream.of(1, 2, 3, 4)
//        .map(func)
                .map(closure)
//        .map(String::valueOf)
                .map(String.&valueOf)
                .forEach(System.out::println)

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

    static def check(boolean condition, Closure closure) {
        if (condition) {
            closure()
        }
    }
}

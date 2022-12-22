package com.dmdev.lesson8

import java.util.regex.Matcher

class RegexRunner {
    static void main(String[] args) {
        String value = "one 1 two 22 three 333"
//        String regex = "\\w+ \\d+"
        String regex = /(\w+) (\d+)/

//        Pattern pattern = Pattern.compile(regex)
//        Pattern pattern = ~regex

//        Matcher matcher = pattern.matcher(value)
        Matcher matcher = value =~ regex

        // 1) если полностью ищем соответствие строки заданному шаблону regex
        // например, номер телефона или электронная почта
//        boolean result = matcher.matches()
        boolean result = value ==~ regex
        println result // false
        println "----------------------"

        // 2) если ищем подтексты во всём нашем тексте
        while (matcher.find()) {
            println matcher.group()
            println matcher.group(1)
            println matcher.group(2)
            println "----------------------"
        }

        // работа с группами
        println matcher[0]
        println matcher[1]
        // второй элемент 1 подгруппы (нумерация начинается с нуля)
        println matcher[1][2]
        // массив из 2 подгрупп (нумерация начинается с нуля)
        println matcher[1..2]
        println matcher[2]
        println "----------------------"

        matcher.each(group -> println group)
        println "----------------------"
        matcher.each ((group, group1, group2) -> {
            println group
            println group1
            println group2
        })
    }
}

package com.dmdev.lesson08

import java.util.regex.Matcher
import java.util.regex.Pattern

class RegexRunner {
  static void main(String[] args) {
    String value = "one 1 two 22 three 333"

    println "В Java:"
    String javaRegex = "(\\w+) (\\d+)"
    Pattern javaPattern = Pattern.compile(javaRegex)
    Matcher javaMatcher = javaPattern.matcher(value)
    // 1) если полностью ищем соответствие строки заданному шаблону regex
    // например, номер телефона или электронная почта
    boolean javaResult = javaMatcher.matches()
    println javaResult
    println "----------------------"
    // 2) если ищем подтексты во всём нашем тексте
    while (javaMatcher.find()) {
      println javaMatcher.group()
      println javaMatcher.group(1)
      println javaMatcher.group(2)
      println "----------------------"
    }

    println "В Groovy:"
    String groovyRegex = /(\w+) (\d+)/
    Pattern groovyPattern = ~groovyRegex         // Pattern.compile(groovyRegex)
    Matcher groovyMatcher = value =~ groovyRegex // Pattern.compile(groovyRegex).matcher(value)
    boolean groovyResult = value ==~ groovyRegex // Pattern.compile(groovyRegex).matcher(value).matches()
    println groovyResult // false
    println "----------------------"
    while (groovyMatcher.find()) {
      println groovyMatcher.group()
      println groovyMatcher.group(1)
      println groovyMatcher.group(2)
      println "----------------------"
    }

    // работа с группами
    println groovyMatcher[0]     // [one 1, one, 1]
    println groovyMatcher[1]     // [two 22, two, 22]
    // второй элемент 1 подгруппы
    println groovyMatcher[1][2]  // 22
    // массив из 2 подгрупп
    println groovyMatcher[1..2]  // [[two 22, two, 22], [three 333, three, 333]]
    println groovyMatcher[2]     // [three 333, three, 333]
    println "----------------------"

    groovyMatcher.each(group -> println group)
    println "----------------------"
    groovyMatcher.each((group, group1, group2) -> {
      println group
      println group1
      println group2
    })
  }
}

package com.dmdev.lesson05

import groovy.transform.CompileStatic

import java.sql.Date as SqlDate

/**
 * byte, short, int, long, BigInteger
 * float, double, BigDecimal
 * char
 * boolean
 * В Groovy все примитивные типы данных транслируются в обёртки
 * Дефолтные импорты в Groovy:
 * import java.lang.*
 * import java.util.*
 * import java.io.*
 * import java.net.*
 * import groovy.lang.*
 * import groovy.util.*
 * import java.math.BigInteger
 * import java.math.BigDecimal
 */
@CompileStatic
// аннотация используется редко, только на первых порах - чтобы ловить ошибки на этапе компиляции [Static type checking]
class VariablesRunner {
  static void main(String[] args) {
//        int value = 5
//        Integer value = 5
    def value = 5        // Integer
    def value2 = 36G   // BigInteger
    def value3 = 3.4G // BigDecimal
//        new SqlDate() // проверка синтаксиса будет на этапе runtime по умолчанию, пока не включим @CompileStatic
    println new SqlDate(1713640410185).toLocalDateTime()
  }
}

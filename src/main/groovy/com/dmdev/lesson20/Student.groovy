package com.dmdev.lesson20

import groovy.transform.ToString
import groovy.transform.builder.Builder

// @Slf4j      // из пакета groovy.util.logging
// @TupleConstructor + @EqualsAndHashCode + @ToString
// @Immutable // @Canonical + final fields
// @Canonical
@Builder
@ToString
/**
 * Пример AST-трансформаций (compile time programming) с помощью аннотаций
 */
class Student {
  String firstName
  String lastName
  Integer age

  static void main(String[] args) {
    def student = builder()
        .lastName("Petrov-Vodkin")
        .firstName("Kuzma")
        .age(46)
        .build()
    println student
  }
}
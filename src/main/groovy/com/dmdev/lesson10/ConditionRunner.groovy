package com.dmdev.lesson10

/**
 * В if можно засунуть не только boolean, но и другие типы данных:
 * <ul>
 *   <li>boolean</li>        - is true
 *   <li>Collection/Map</li> - is not empty
 *   <li>Matcher</li>        - has match
 *   <li>String/GString</li> - is not empty
 *   <li>Number/Char </li>   - != 0
 *   <li>reference</li>      - != null
 * </ul>
 */
class ConditionRunner {
  static void main(String[] args) {
    // в Java:
    int x = 10
    if (x > 0) {
      println x
    }
    boolean booleanResult = x > 0
    if (booleanResult) {
      println x
    }
    println "----------------------"
    // в Groovy:
    if (x) {
      println x
    }
    println "----------------------"
    def person = new Person(19)
    // if (person != null)
    if (person) {
      println person.id()
    }
    person?.id() // null safe
    println "----------------------"
    def result = x != 0 ? x : 1
    println result // 10
    println "----------------------"
    if (x != 0) {
      println x
    } else {
      println 1
    }
    println "----------------------"
    if (x) {
      println x
    } else {
      println 1
    }
    println "----------------------"
    result = x ? x : 1
    println result
    println "----------------------"
    result = x ?: 1
    println result
  }
}

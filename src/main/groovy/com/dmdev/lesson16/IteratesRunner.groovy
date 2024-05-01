package com.dmdev.lesson16

import com.dmdev.lesson10.Person

/**
 * Методы, которые есть в любых groovy-объектах:
 * <ul>
 *   <li>boolean any {closure}</li>
 *   <li>Collection collect {closure}</li>
 *   <li>Object each {closure}</li>
 *   <li>Object eachWithIndex {closure}</li>
 *   <li>boolean every {closure}</li>
 *   <li>Object find {closure}</li>
 *   <li>Collection findAll {closure}</li>
 *   <li>int findIndexOf {closure}</li>
 *   <li>List findIndexValues {closure}</li>
 *   <li>int findLastIndexOf {closure}</li>
 *   <li>Object inject {closure}</li> - похож на reduce()
 *   <li>Collection split {closure}</li> - похож на group()
 *   <li>List grep(Object filter)</li>
 * </ul>
 */
class IteratesRunner {
  static void main(String[] args) {
    assert [1, 4, 7, 9].any { it % 2 == 0 }  // есть хотя бы одно чётное число
    assert [1, 4, 7, 9].find {it % 2 == 0} == 4 // первое попавшееся четное число
    assert [1, 4, 7, 9].findAll { it % 2 != 0 } == [1, 7, 9]
    assert (2..4).collect() == [2, 3, 4]

    def person = new Person(25)
    // все объекты рассматриваются в виде коллекции, состоящей из 1 элемента
    person.each { println it }

    // в shell grep используется только в качестве поиска подстрок в тексте (обычный regex)
    // в Groovy grep используется с любыми объектами
    // pattern.matcher(elem.toString()).matches()
    // под капотом вызывается isCase
    assert ["asd", "dsf", "12", "546", "234df"].grep(~/\d+/) == ["12", "546"]
    // у closure будет неявно вызван метод call()
    assert ["asd", "dsf", "12", "546", "234df"].grep { it.length() > 4 } == ["234df"]
  }
}

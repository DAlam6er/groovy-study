package com.dmdev.lesson15

/**
 * Реализации интерфейса Range:
 * <ul>
 *   <li>EmptyRange</li>
 *   <li>IntRange</li>
 *   <li>NumberRange</li>
 *   <li>ObjectRange</li>
 * </ul>
 * Основные методы:
 * <ul>
 *   <li>getFrom()</li>
 *   <li>getTo()</li>
 *   <li>isReverse()</li>
 *   <li>containsWithinBounds()</li>
 *   <li>step()</li>
 *   <li>inspect()</li>
 * </ul>
 */
class RangeRunner {
  static void main(String[] args) {
    def range = 2..8 // закрытый диапазон
    // класс, который наследуется от AbstractList<Integer> и реализует интерфейс Range<Integer>
    assert range.getClass() == IntRange

    assert range.get(3) == 5
    assert range.contains(8)

    range = 2..<8 // открытый диапазон
    assert !range.contains(8)

    // метод содержится в DefaultGroovyMethods и добавляется динамически в runtime
    range.each { println it } // 2, 3, 4, 5, 6, 7
    println "-----------------------------------------------"

    ('a'..'d').each { println it }
    println "-----------------------------------------------"

    // Enum WeekDay под капотом содержит два дополнительных метода:
    // next() и previous().
    // Их следует реализовать в классе, реализующем интерфейс Range
    (WeekDay.MO..WeekDay.FR).each { println it }
    println "-----------------------------------------------"

    // обратный порядок
    (WeekDay.FR..WeekDay.MO).each { println it }
    // Range также реализует метод isCase(), поэтому удобно использовать в switch
    // - аналог метода contains
  }
}

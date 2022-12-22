package com.dmdev.lesson15

class RangeRunner {
    static void main(String[] args) {
        def range = 2..8
        assert range.getClass() == IntRange

        assert range.get(3) == 5
        assert range.contains(8)

        range = 2..<8
        assert !range.contains(8)

        range.each {println it}
        println "-----------------------------------------------"
        ('a'..'d').each {println it}
        println "-----------------------------------------------"
        // Enum WeekDay под капотом содержит два дополнительных метода:
        // next() и previous().
        // Их следует реализовать в классе, реализующем интерфейс Range
        (WeekDay.MO..WeekDay.FR).each {println it}
        println "-----------------------------------------------"
        // обратный порядок
        (WeekDay.FR..WeekDay.MO).each {println it}
        // Range также реализует метод isCase(), поэтому удобно использовать в switch
        // - аналог метода contains
    }
}

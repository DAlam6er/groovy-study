package com.dmdev.lesson16

import com.dmdev.lesson10.Person

class IteratesRunner {
    static void main(String[] args) {
        assert [1, 4, 7, 9].any {it % 2 == 0}
        assert [1, 4, 7, 9].findAll {it % 2 != 0} == [1, 7, 9]
        assert (2..4).collect() == [2, 3, 4]

        def person = new Person(25)
        // все объекты рассматриваются в виде коллекции, состоящей из 1 элемента
        person.each { println it}

        // в shell grep используется только в качестве поиска подстрок в тексте (обычный regex)
        // в Groovy grep используется с любыми объектами
        // pattern.matcher(elem.toString()).matches()
        // под капотом вызывается isCase
        assert ["asd", "dsf", "12", "546", "234df"].grep(~/\d+/) == ["12", "546"]
        assert ["asd", "dsf", "12", "546", "234df"].grep {it.length() > 4} == ["234df"]
    }
}

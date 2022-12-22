package com.dmdev.lesson13

class ListRunner {
    static void main(String[] args) {
        def list = [1, 3, 5, 6]
        assert list.getClass() == ArrayList

        // read
        assert list[2] == 5
        assert list.get(2) == 5
        assert list[-1] == 6 // list.get(list.size() - 1)
        // подсписок - 1..3 - range
        // под капотом вызывается метод createRange у класса ScriptBytecodeAdapter
        assert list[1..3] == [3, 5, 6]
        // в Java было бы выброшено IndexOutOfBoundException
        // в старых версиях Groovy необходимо было писать list?[8]
        assert list[8] == null // list.get(8)

        // write
        list += 9
        // добавляем подряд несколько элементов
        list << 11 << 13 << 7 << 7
        assert list == [1, 3, 5, 6, 9, 11, 13, 7, 7]
        // удаляем все вхождения числа 7
        list -= 7
        assert list == [1, 3, 5, 6, 9, 11, 13]
        // удаление всех элементов, входящих в указанный список
        list -= [1, 3]
        assert list == [5, 6, 9, 11, 13]
        list *= 3
        assert list == [5, 6, 9, 11, 13, 5, 6, 9, 11, 13, 5, 6, 9, 11, 13]

        // methods from queue
        list.push(999)
        assert list.pop() == 999
        assert list.head() == 5
        assert list.tail() == [6, 9, 11, 13, 5, 6, 9, 11, 13, 5, 6, 9, 11, 13]
        assert list.last() == 13

        // new methods
        // разворачивание списка
        assert [1, 2, [4, 6, 7], 9].flatten() == [1, 2, 4, 6, 7, 9]
        // обратный порядок списка
        assert [1, 2, 3].reverse() == [3, 2, 1]
        // поиск пересечений
        assert [1, 2, 3].intersect([2, 3, 7]) == [2, 3]
        // проверка на предмет отсутствия пересечений
        assert [1, 2, 3].disjoint([5, 6, 7])

        // new operators
        // множественное присвоение (multiple assignment)
        def (a, b, c) = [3, 5, 7, 9, 10]
        assert a == 3
        assert b == 5
        assert c == 7

        // spread-оператор * — для разбиения массива на 2 переменные
        // под капотом вызывается метод createList у класса ScriptBytecodeAdapter
        // при этом возвращается объект типа List
        func(*[8,10])
     }

    static def func(def a, def b) {
        println a
        println b
    }
}

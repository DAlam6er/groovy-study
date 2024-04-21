package com.dmdev.lesson14

class MapRunner {
  static void main(String[] args) {
    def emptyMap = [:]
    println emptyMap
    def map = ["one" : 1, "two" : 2]
    println map
    // если ключ - это String, можем опустить кавычки
    map = [one: 1, two: 2]
    assert map.getClass() == LinkedHashMap

    // read
    // работаем с ключами, словно с полями
    assert map.get("one") == 1
    assert map["one"] == 1
    assert map."one" == 1
    assert map.one == 1 // в случае если ключ - это String, опускаем кавычки
    assert map.get("qwe", 10) == 10 // в Java map.getOrDefault()

    // write
    // перезаписываем значение по указанному ключу
    map.one = 111 // map.put(key, value), map.putAll(anotherMap)
    // добавляем новый элемент
    map.three = 3

    // new methods
    // подмножество
    assert map.subMap("one", "two") == [one: 111, two: 2]

    // new operators
    // spread-оператор *:
    // добавляем в новый ассоциативный массив элементы из старого
    def newMap = ["q": 22, "rt": 99, *: map]
    println newMap
  }
}

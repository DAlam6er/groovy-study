package com.dmdev.lesson26.task1

import com.dmdev.lesson17.Student

/**
 * Добавить метод инициализации "make" для создания объектов любых классов.
 * Метод должен проксировать вызов на соответствующий конструктор
 */
class Task1 {
  static void main(String[] args) {
    // необходимо подправить метакласс у класса Class
    // на самом деле добавляем не метод, а property, которым является Closure
    // далее необходимо перенаправить запрос на соответствующий конструктор
    // т.к. только конструкторы создают экземпляры классов
    // следовательно, необходимо обратиться к ДЕЛЕГАТУ Closure
    // и вызвать у его метакласса конструктор, передав туда все параметры
    Class.metaClass.make = { Object[] values ->
      println thisObject
      println owner
      println delegate

      // будем использовать delegate, а не owner или thisObject,
      // т.к. когда мы подправляем метакласс,
      // то все делегаты автоматически относятся к тем ОБЪЕКТАМ,
      // у которых был вызван наш соответствующий метод — make
      // например для Hashset delegate будет указывать на объект класса Class<HashSet>
      delegate.metaClass.invokeConstructor(values)
    }

//        new HashSet<>([1, 2, 3, 4, 4])
    def hashSet = HashSet.make([1, 2, 3, 4, 4])
    def student = Student.make("Ivan", "Ivanov", 20)
    def student2 = Student.make()

    println hashSet
    println student
    println student2
  }
}

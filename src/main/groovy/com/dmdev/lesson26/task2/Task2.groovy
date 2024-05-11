package com.dmdev.lesson26.task2

/**
 * Добавить возможность складывать различные единицы измерения.
 * Например, 3.cm + 1.m - 25.mm = 1005 (mm)
 */
class Task2 {
  static void main(String[] args) {
//        firstOption()
//        secondOption()
    thirdOption()
  }

  /**
   * Решение задачи с помощью категорий
   */
  private static void firstOption() {
    use(IntegerMethods) {
      def result = 3.cm + 1.m - 25.mm
      assert result == 1005
    }
  }

  /**
   * Более глобальный вариант - через метаклассы - добавляем в класс Integer
   * 3 новых метода
   */
  private static void secondOption() {
    Integer.metaClass.getCm = {
//      this * 10 // thisObject - Task2
      delegate * 10 // delegate относится к тому объекту, у которого вызвали метод getCm
    }

    Integer.metaClass.getM = {
      delegate.cm * 100
    }

    Integer.metaClass.getMm = {
      delegate
    }

    def result = 3.cm + 1.m - 25.mm
    assert result == 1005
  }

  /**
   * Второй вариант, но с более компактной записью
   * используется статический метод класса DefaultGroovyMethods
   * static MetaClass metaClass(Class self, Closure closure)
   */
  private static void thirdOption() {
    Integer.metaClass {
      getCm = {
        delegate * 10
      }
      getM = {
        delegate.cm * 100
      }
      getMm = {
        delegate
      }
    }

    def result = 3.cm + 1.m - 25.mm
    assert result == 1005
  }
}

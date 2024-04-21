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

  // Более глобальный вариант
  private static void secondOption() {
    Integer.metaClass.getCm = {
      delegate * 10
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

  // Второй вариант, но с более компактной записью
  // используется статический метод класса DefaultGroovyMethods
  // static MetaClass metaClass(Class self, Closure closure)
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

  private static void firstOption() {
    use(IntegerMethods) {
      def result = 3.cm + 1.m - 25.mm
      assert result == 1005
    }
  }
}

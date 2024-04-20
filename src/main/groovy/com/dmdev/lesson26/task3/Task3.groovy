package com.dmdev.lesson26.task3
/**
 * Реализовать механизм тестирования через BDD (Behavior Driven Development):
 * given {
 *     a = 2
 *     b = 4
 * } when {
 *     result = a + b
 * } then {
 *     result == 6
 * }
 */
class Task3 {
    static void main(String[] args) {
        // methods chain, используемый в шаблоне проектирования Builder
        // given(Closure{}).when(Closure{}).then(Closure{})

        // используем последнее значение как Closure, в таком случае будем использовать его как блок кода
        // можно опустить скобки (), т.к. Closure единственный параметр у метода given
        // когда мы обращаемся к property a или b, мы на самом деле делегируем запрос к valueHolder

        // 1. Closure declaration
        given {
            a = 2   // map.a = 2 // propertyMissing -> map.put("a", 2)
            b = 4
        } when {
            result = a + b
        } then {
            result == 6
        }
    }

    // 2. Closure execution
    static Map given(Closure closure) {
        def valueHolder = [:]
//        closure.delegate = valueHolder
//        closure.resolveStrategy = DELEGATE_ONLY
//        closure()
        valueHolder.with closure
        [when: { Closure whenClosure ->
            {
                valueHolder.with whenClosure
                [then: { Closure thenClosure ->
                    thenClosure.delegate = valueHolder
                    thenClosure.resolveStrategy = DELEGATE_ONLY
                    assert thenClosure()
                }]
            }
        }]
    }
}

package com.dmdev.lesson10

/**
 * boolean              is true
 * Collection/Map       is not empty
 * Matcher              has match
 * String/GString       is not empty
 * Number/Char          != 0
 * reference            != null
 */
class ConditionRunner {
    static void main(String[] args) {
        int x = 10

//        boolean booleanResult = x > 0
//        if (booleanResult) {
//            println x
//        }
        if (x) {
            println x
        }

        def person = new Person(19)
//        if (person) {
//            println person.getId()
//        }
        person?.getId()
    }
}

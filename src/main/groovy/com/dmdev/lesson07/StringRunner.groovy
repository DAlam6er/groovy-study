package com.dmdev.lesson07

/**
 * 6 вариантов того, как можно создавать строки в Groovy
 * <ul>
 *     <li>"интерполяция поддерживается"</li>
 *     <li>'интерполяция не поддерживается'</li>
 *     <li>"""интерполяция поддерживается"""</li>
 *     <li>'''интерполяция не поддерживается'''</li>
 *     <li>/интерполяция поддерживается/</li>
 *     <li>$/интерполяция поддерживается/$</li>
 * </ul>
 */
def name = "Ivan \"\""

// интерполяция строк не поддерживается - обычная строка
def value = 'Hello "Hi!" \'\''
// для символов необходимо явно задавать тип
char letter = 'H'
assert letter instanceof Character

// Все String interpolation становятся объектом GString
def stringValue = "Hello $name" // интерполяция
println stringValue

// Object value2 = "\nSELECT *\nFROM table\nWHERE name = ?\n";
def value2 = """
SELECT *
FROM table
WHERE name = ?
"""
println value2

// Object value3 = new GStringImpl(new Object[]{name}, new String[]{"\nSELECT *\nFROM table\nWHERE name = ", "\n"});
def value3 = """
SELECT *
FROM table
WHERE name = $name
"""
println value3

// интерполяция строк не поддерживается
// В Groovy скриптах допустимо не использовать def
value4 = '''
SELECT *
FROM table
WHERE name = $name
'''
println value4

// интерполяция поддерживает не только переменные, но и вызов функций
def value5 = "Good morning ${getWithPrefix(name)}"
println value5

// если не используется return - автоматически используется последняя строка
static def getWithPrefix(String name) {
  "Mr." + name
}

// не нужно экранировать ни двойные кавычки, ни одинарные
def value6 = /Hello "$name"'/
// не нужно экранировать доллар в регулярных выражениях
def value7 = $/Hello $name/$

// работа со строками в стиле Python, гораздо удобнее работать, чем в Java
println name[2]
println name[-1]
println name[1]
println name[1..3]
println name[1..-1]
println name * 3
println name - 'Iv'
println name - 'an'
println name - 'na' // удаляет первое соответствие
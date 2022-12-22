package com.dmdev.lesson7

/**
 * " "
 * ' '
 * """ """
 * ''' '''
 * / /
 * $/ /$
 */
def name = "Ivan"

// интерполяция строк не поддерживается
def value = 'Hello "Hi!" \'\''
char letter = 'H'
assert letter instanceof Character

def stringValue = "Hello $name"
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
value4 = '''
SELECT *
FROM table
WHERE name = $name
'''
println value4

def value5 = "Good morning ${getWithPrefix(name)}"
println value5

static def getWithPrefix(String name) {
    "Mr." + name
}

def value6 = /Hello $name/
def value7 = $/Hello $name/$

// работа со строками в стиле Python
println name[2]
println name[1]
println name[1..3]
println name[1..-1]
println name * 3
println name - 'Iv'
println name - 'an'
package com.dmdev.lesson19

import groovy.io.FileType

/**
 * В Groovy принято использовать uncatched exceptions. Не нужно ничего отлавливать,
 * только программист решает, нужно ли ему в каком-то месте использовать try-catch
 */
class IORunner {
  static void main(String[] args) {
    def file = new File(".gitignore")

    // read (нет необходимости открывать/закрывать поток InputStream)
    println file.text

    file.each { line -> println line }
    // закрывать InputStream не нужно
    file.withInputStream {
      def allText = new String(it.readAllBytes())
      println allText
    }

    def writer = new StringWriter() // закрывать необязательно, т.к. writer in-memory
    // закрывать Reader НУЖНО
    try (def reader = file.newReader()) {
      // запишем в writer всё содержимое reader
      writer << reader
    }

    // write
    def file2 = new File("text.txt")
    // перезаписывает полностью содержимое файла
    file2.text = "Some text"

    // для записи в режиме добавление:
    file2 << "New line" << System.lineSeparator()

//        file2.withOutputStream {} // закрывать не нужно
//        try(def stream = file2.newOutputStream()) {}

    def srcDir = new File("src")

    srcDir.eachDir { println it }
    println "---------------------------------------------------"
    // рекурсивно пробегаем по всем директориям, которые есть в src
    srcDir.eachDirRecurse { println it }
    println "---------------------------------------------------"
    srcDir.eachFileRecurse(FileType.FILES) { println it }
  }
}

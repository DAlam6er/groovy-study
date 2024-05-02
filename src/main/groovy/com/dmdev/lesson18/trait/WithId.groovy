package com.dmdev.lesson18.trait

/**
 * В отличие от интерфейсов Java, traits могут содержать состояния
 * Trait - это черта, особенность, которую мы добавляем какому-то классу
 */
trait WithId {
  Integer id // в Java пришлось бы писать метод getId(); и реализовывать его во всех классах

  boolean validateId() {
    id > 0
  }
}
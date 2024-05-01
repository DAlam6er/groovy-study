package com.dmdev.lesson18.trait

/**
 * В отличие от интерфейсов Java, traits могут содержать состояния
 * Trait - это черта, особенность, которую мы добавляем какому-то классу
 */
trait WithId {
  Integer id

  boolean validateId() {
    id > 0
  }
}
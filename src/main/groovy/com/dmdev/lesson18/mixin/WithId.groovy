package com.dmdev.lesson18.mixin

trait WithId {
  Integer id

  boolean validateId() {
    id > 0
  }
}
package com.dmdev.lesson18.mixin.static_

import groovy.transform.TupleConstructor

@TupleConstructor
class WithId {
  Integer id

  boolean validateId() {
    id > 0
  }
}
package com.cloudwick.scala

class Reference[T] {

  private var contents: T = _

  def set(value: T) = (contents = value)
  def get: T = contents

}
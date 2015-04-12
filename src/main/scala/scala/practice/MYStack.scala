package com.cloudwick.scala

class MYStack[T] {

  var elements: List[T] = Nil

  def push(x: T) {
    elements = x :: elements
  }

  def pop() {
    elements = elements.tail
  }

  def top() = {
    val t = elements.head
    t
  }

}
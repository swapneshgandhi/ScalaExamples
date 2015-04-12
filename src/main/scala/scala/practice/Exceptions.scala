package com.cloudwick.scala

import java.util.Date

object Exceptions extends App {

  def fact(num: Int): Int = {

    def data(n: Int, acc: Int): Int = {
      if (n <= 0) {
        acc
      } else {
        data(n - 1, acc * n)
      }
    }

    data(num, 1)
  }

  println(fact(1))

}
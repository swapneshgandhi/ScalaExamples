package com.cloudwick.scala

object Timer extends App {

  def everySecond(calback: () => Unit) {
    while (true) {
      calback(); Thread sleep 1000

    }
  }

  def printData() {
    println("I live in Fremiefd")
  }

  //everySecond { () => printData }

  everySecond( () => println("I am in NEWARK"))

}
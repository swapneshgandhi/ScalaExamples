package com.cloudwick.scala

object IntReference extends App {

  var obj = new Reference[Int]
  obj.set(12)
  println(obj.get)

}

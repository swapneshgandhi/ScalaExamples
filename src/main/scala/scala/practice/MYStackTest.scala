package com.cloudwick.scala

object MYStackTest extends App{

  var stack = new MYStack[Int]
  
  stack.push(11)
  stack.push('c')
  stack.push('a')
  //stack.push(12)
  
  println(stack.top)
  
}
package nintynineproblems

/**
 * Created by swaps_000 on 3/30/2015.
 */
object HigherOrderAndCurrying {

  /*# Scala
code and some syntax

//https://class.coursera.org/progfun-004/wiki/CheatSheet

# higher order - passing anonymous func
*/

  def sum(func: (Int, Int) => Int)(a: Int, b: Int): Int = {
    func(a, b)
  }

  sum((x: Int, y: Int) => x + y)(12, 2)

  def sum2(func: (Int) => Int)(a: Int): Int = {
    func(a)
  }

  sum2(x => x * x)(1)

  //currying
  //Converting a function with multiple arguments into a function with a single argument that returns another function.

  def general(f: Int => Int, g: (Int, Int) => Int, zero: Int)(x: Int, y: Int): Int = {

    if (x > y) zero

    else
      g(f(x), general(f, g, zero)(x + 1, y))
  }

  def product(func: Int => Int)(x: Int, y: Int): Int = general(x => x, (x, y) => x * y, 1)(x, y)

  def fact(n: Int) = product(x => x)(1, n)

  fact(5)

}

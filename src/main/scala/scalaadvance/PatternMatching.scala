package scalaadvance

/**
 * Created by swaps_000 on 3/30/2015.
 */
object PatternMatching {

  // remember
  //  ( h :: _ ) -- pattern to match a string means you are only concerned with h and _ is any other part of it- can be Nil too

  trait Expr {
  }

  case class Sum(e1: Expr, e2: Expr) extends Expr {

  }

  case class Number(number1: Int) extends Expr {

  }

  case class Var(var1: String) extends Expr {

  }

  case class Product(e1: Expr, e2: Expr) extends Expr {

  }


  def show(e: Expr): String = e match {

    case Number(x) => x.toString

    case Sum(l, r) => show(l) + " + " + show(r)

    case Product(l: Sum, r) => "(" + show(l) + ")" + " * " + show(r)

    case Product(l, r: Sum) => show(l) + " * " + "(" + show(r) + ")"

    case Var(l) => l

  }

  show(Number(2))

  show(Sum(Number(1), Number(2)))

  show(Product(Sum(Var("x"), Number(2)), Var("y")))


  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => x :: Nil
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

}


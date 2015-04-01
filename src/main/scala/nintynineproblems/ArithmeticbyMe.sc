/**
 * Created by swaps_000 on 3/30/2015.
 */

// P31 (**) Determine whether a given integer number is prime.
//     scala> 7.isPrime
//     res0: Boolean = true

// A fairly naive implementation for primality testing is simply: a number is
// prime if it it not divisible by any prime number less than or equal to its
// square root.
// Here, we use a Stream to create a lazy infinite list of prime numbers.  The
// mutual recursion between `primes` and `isPrime` works because of the limit
// on `isPrime` to the square root of the number being tested.

object S99Int {

  val primes = Stream.cons(2, Stream.from(3, 2).filter(isPrime(_)))

  def isPrime(start: Int): Boolean =
    (start > 1) && (primes takeWhile {
      _ <= Math.sqrt(start)
    } forall {
      start % _ != 0
    })
}

class S99Int(start: Int) {
  val primes = Stream.cons(2, Stream.from(3, 2).filter(_ => isPrime))

  def isPrime: Boolean =
    (start > 1) && (primes takeWhile {
      _ <= Math.sqrt(start)
    } forall {
      start % _ != 0
    })

  def listPrimeRange(r: Range) = {
    primes dropWhile (_ < r.start) takeWhile (_ > r.end) toList
  }

}

// Readers interested in more sophisticated (and more efficient) primality tests
// are invited to read http://primes.utm.edu/prove/index.html .  Implementation
// in Scala is left as an exercise for the reader.

// Similarly, a more efficient, functional, lazy, infinite prime list can be found
// at http://article.gmane.org/gmane.comp.lang.haskell.cafe/19470 .  (Haskell
// implementation.)

def gcd(fno: Int, lno: Int): Int = {
  if (lno == 0) fno
  else gcd(lno, fno % lno)
}

class Prime(val num: Int) {

  def isCoPrime(n: Int): Boolean = {
    gcd(num, n) == 1
  }

  new Prime(23).isCoPrime(2)

  // P34 (**) Calculate Euler's totient function phi(m).
  //     Euler's so-called totient function phi(m) is defined as the number of
  //     positive integers r (1 <= r < m) that are coprime to m.  As a special
  //     case, phi(1) is defined to be 1.
  //
  //     scala> 10.totient
  //     res0: Int = 4


  def totient: Int = (1 to num).filter(new Prime(num).isCoPrime(_)).length
}

val primeObj = S99Int
/*
taken form ninty nine
 */

def primeFactor(num: Int): List[Int] = {
  def primeFactorsR(n: Int, ps: Stream[Int]): List[Int] =
    if (primeObj.isPrime(n)) List(n)
    else if (n % ps.head == 0) ps.head :: primeFactorsR(n / ps.head, ps)
    else primeFactorsR(n, ps.tail)

  primeFactorsR(num, primeObj.primes)
}


/*
@author
Swapnesh
 */

def pack[A](ls: List[A]): List[List[A]] = {
  if (ls.isEmpty) List(List())
  else {
    val (packed, next) = ls span {
      _ == ls.head
    }
    if (next == Nil) List(packed)
    else packed :: pack(next)
  }
}

def encode[A](ls: List[A]): List[(Int, A)] =
  pack(ls) map { e => (e.length, e.head) }


def primeFactorMy(num: Int): List[Int] = {

  def primeFactorsRMy(n: Int, ps: Int, result: List[Int]): List[Int] = {

    if (n % ps == 0)
      if (primeObj.isPrime(n / ps)) (result :+ ps) :+ (n / ps)
      else ps :: primeFactorsRMy(n / ps, ps, result)
    else primeFactorsRMy(n, findNextPrime(ps), result)

  }
  def findNextPrime(ps: Int): Int = {
    primeObj.primes.indexOf(ps) + 1
  }
  primeFactorsRMy(num, 2, Nil)
}


//sorted with length of factors generated from encode
encode(primeFactorMy(20)) map (_.swap) sortWith ((e1, e2) => (e1._2 < e2._2))

def listPrimeRange(r: Range) = {
  primeObj.primes dropWhile (_ < r.start) takeWhile (_ > r.end)
}

val obj = new S99Int(23)
//obj.primes toList

obj.listPrimeRange(1 to 15)

//these prime traversal do not work, but useful to go through them for
//looking at how to do it in Scala

//very good use of Some/None
def goldbach(start: Int): (Int, Int) =
  primeObj.primes takeWhile {
    _ < start
  } find { p => new S99Int(start - p).isPrime } match {
    case None => throw new IllegalArgumentException
    case Some(p1) => (p1, start - p1)
  }

goldbach(28)

def printGoldbachListLimited(r: Range, limit: Int) {
  (r filter { n => n > 2 && n % 2 == 0 } map { n => (n, goldbach(n)) }
    filter {
    _._2._1 >= limit
  })
  for ((k, (v1, v2)) <- _) {
    println(k + ", " + v1 + v2)
  }

  def printPair(n: Int, p1: Int, p2: Int) {
    println(n + ", " + p1 + " " + p2)
  }

}
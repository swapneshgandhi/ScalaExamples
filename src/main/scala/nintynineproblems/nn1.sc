val myList = List(1, 3, 2, 3)

def duplicateList[T](l: List[T]): List[T] = {
  l flatMap {
    x => List(x, x)
  }
}

duplicateList(myList)

def nTimes[A](a: A, n: Int): List[A] = {
  var list: List[A] = List()
  for (i <- 0 until (n)) {
    list = list ++ List(a)
  }
  list
}


nTimes(3, 2)

def duplicateN[A](n: Int, ls: List[A]): List[A] = {
  ls flatMap {
    x => nTimes(x, n)
  }
}

duplicateN(3, myList)
 
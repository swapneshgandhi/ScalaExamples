
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

def lsort[A](ls: List[List[A]]): List[List[A]] =
  ls sortWith {
    _.length < _.length
  }

def lsortFreq[A](ls: List[List[A]]): List[List[A]] = {
  val freqs = Map(encode(ls map {
    _.length
  } sortWith {
    _ < _
  }) map {
    _.swap
  }: _*)
  ls sortWith { (e1, e2) => freqs(e1.length) < freqs(e2.length) }
}

val ls = List(List(1), List(1, 2), List(2, 3))

val enc = Map(encode(ls map {
  _.length
} sortWith {
  _ < _
}) map {
  _.swap
}
  : _*)
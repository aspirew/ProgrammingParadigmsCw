def sumProd(xs: List[Int]): (Int, Int) =
xs match {
  case h::t => {
    val (s, p) = sumProd(t)
    (h + s, h * p)
  }
  case Nil => (0, 1)
}

def sumProd2 (xs: List[Int]) =
  (xs foldLeft (0,1)) ((acc, h) => (acc._1 + h, acc._2*h))
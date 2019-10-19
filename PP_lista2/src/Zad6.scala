def replaceNth[A](xs: List[A], n:Int, x:A):List[A] = {
  if(n > xs.length) throw new Exception("Position is too big")
  def replaceNthHelper[A](xs: List[A], n:Int, x:A):List[A] = {
    if (n > 0) xs.head :: replaceNthHelper(xs.tail, n - 1, x) else
    if (n == 0) x :: xs.tail
    else throw new Exception("Position is negative")
  }
    replaceNthHelper(xs, n, x)
}

def replaceNth[A](xs: List[A], n:Int, x:A):List[A] =
  (xs, n) match {
    case (Nil, _) => Nil
    case (_::tl, 0) => x :: tl
    case (hd::tl, i) => hd :: replaceNth(tl, i-1, x)
  }
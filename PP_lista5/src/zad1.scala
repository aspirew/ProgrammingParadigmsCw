def ltake [A](k: Int, llist: LazyList[A]):List[A] =
  (k, llist) match {
    case (0, _) => Nil
    case (_, LazyList()) => Nil
    case (n, hd#::tl) => hd::ltake(n-1, tl)
  }

def lfrom (k:Int):LazyList[Int] = k#::lfrom(k+1)

def lrepeat[A](k: Int)(lxs: LazyList[A]):LazyList[A]= {
  if (k < 1) throw new Exception ("liczba powtorzen mniejsza niz 1")
  def lrepeatHelper(rpts: Int, rest: LazyList[A]): LazyList[A] =
    (rpts, rest) match {
      case (_, LazyList()) => LazyList()
      case (0, hd #:: tl) => lrepeatHelper(k, tl)
      case (_, hd #:: tl) => hd#::lrepeatHelper(rpts - 1, rest)
    }
  lrepeatHelper(k, lxs)
}
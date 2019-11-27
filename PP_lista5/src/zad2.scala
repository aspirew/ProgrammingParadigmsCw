def ltake [A](k: Int, llist: LazyList[A]):List[A] =
  (k, llist) match {
    case (0, _) => Nil
    case (_, LazyList()) => Nil
    case (n, hd#::tl) => hd::ltake(n-1, tl)
  }

def lfrom (k:Int):LazyList[Int] = k#::lfrom(k+1)

val lfib = { // val zapamiętuje wartość. Raz obliczone początkowe wartości ciągu
  //zostaną obliczone, a następne będą doklejane. Def oblicza za każdym razem
  def lfibHelper(p: Int, s: Int): LazyList[Int] = {
    s #:: lfibHelper(s, s + p)
  }
  0#::lfibHelper(0, 1)
}



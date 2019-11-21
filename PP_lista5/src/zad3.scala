sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

def generateTree(n: Int):lBT[Int] =
LNode(n, ()=>generateTree(2*n), ()=>generateTree(2*n+1))

def lBreadth[A](ltree: lBT[A]): LazyList[A] = {
  def lBreadthHelper(list: List[lBT[A]]):LazyList[A] =
    list match{
      case Nil => LazyList()
      case LEmpty::tl => lBreadthHelper(tl)
      case LNode(v, l, r)::tl => v #:: lBreadthHelper(tl ++ List(l(), r()))
    }
  lBreadthHelper(List(ltree))
}
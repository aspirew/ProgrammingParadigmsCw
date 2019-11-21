sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem: A, left:BT[A], right:BT[A]) extends BT[A]

val t = Node(1, Node(2, Node(4, Empty, Empty),  Empty), Node(3, Node(5, Empty, Node(6, Empty, Empty)), Empty))

def breadthBT[A](tree:BT[A]):List[A] = {
  def breadthBTHelper(Queue: List[BT[A]]): List[A] = Queue match {
      case Nil => Nil
      case Empty::tail => breadthBTHelper(tail)
      case Node(v, l, r)::tail => v::breadthBTHelper(tail++List(l, r))
    }
  breadthBTHelper(List(tree))
}


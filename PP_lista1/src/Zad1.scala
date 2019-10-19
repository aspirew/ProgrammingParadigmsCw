val list = List(List(1,2),List(3,6),List(1))

def flatten[A](listOfLists:List[List[A]]):List[A] =
  if (listOfLists == Nil) Nil else
    listOfLists.head ++ flatten(listOfLists.tail)


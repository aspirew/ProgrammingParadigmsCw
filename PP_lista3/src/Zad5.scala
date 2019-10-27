
def isBigger (element1:Int, element2:Int):Boolean = element1 > element2

def insertionsort [A](compare:(A, A) => Boolean, list:List[A]):List[A] = {
  def innerSort[A](compare:(A, A) => Boolean, list: List[A], resultList: List[A]): List[A] =
    (list, resultList) match {
      case (Nil, _) => resultList
      case (list, Nil) => innerSort(compare, list.tail, list.head::Nil)
      case (listUnordered, listOrdered) => {
        def checker (element:A, resultList:List[A]):List[A] =
          if(resultList == Nil) element::Nil
          else if(compare(element, resultList.head)) resultList.head::checker(element, resultList.tail)
          else element::resultList
        innerSort(compare, list.tail, checker(listUnordered.head, listOrdered))
      }
    }
  innerSort(compare, list, List())
}


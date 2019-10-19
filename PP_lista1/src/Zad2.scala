val list = List(1,2,3,4,1,5,6,7)

def count[A](element:A, listOfElements:List[A]):Int =
  if (listOfElements == Nil) 0 else
  if (listOfElements.head == element) 1+count(element, listOfElements.tail) else
    count(element, listOfElements.tail)
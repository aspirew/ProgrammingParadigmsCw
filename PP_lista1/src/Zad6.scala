def listLength[A](lista: List[A]):Int =
if (lista == Nil) 0 else
  1 + listLength(lista.tail)
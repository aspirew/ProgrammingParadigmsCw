def sqrList(lista: List[Int]):List[Int] =
if (lista.length == 0) Nil else
  lista.head*lista.head :: sqrList(lista.tail)
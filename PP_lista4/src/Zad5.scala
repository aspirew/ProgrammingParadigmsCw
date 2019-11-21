sealed trait Graphs[A]
case class Graph[A](succ: A=>List[A]) extends Graphs[A]

val g = Graph((i:Int) => i match {
  case 0 => List(3)
  case 1 => List(2, 0 ,4)
  case 2 => List(1)
  case 3 => Nil
  case 4 => List(0,2)
  case n => throw new Exception("Graph g: Node " + n + " doesnt exist")
})

def depthSearch [A](graph:Graph[A], startElement:A):List[A] = {
  def dSHelp(visited: List[A], stack: List[A]):List[A] =
    if (stack == Nil) Nil
    else if(doesContain(visited, stack.head)) dSHelp(visited, stack.tail)
    else stack.head::dSHelp(stack.head::visited, (graph succ stack.head)++stack.tail)
  dSHelp(List(), List(startElement))
}

def depthSearch [A](graph:Graph[A], startElement:A):List[A] = {
  def dSHelp(visited: List[A], stack: List[A]):List[A] = stack match {
    case Nil => Nil
    case h :: t =>
      if (visited.contains(h)) dSHelp(visited, t)
      else h :: dSHelp(h :: visited, (graph succ h) ++ t)
  }
  dSHelp (List (), List (startElement) )
}

def doesContain [A](lista:List[A], element:A):Boolean = {
  if (lista == Nil) false
  else if (lista.head == element) true
  else doesContain(lista.tail, element)
}



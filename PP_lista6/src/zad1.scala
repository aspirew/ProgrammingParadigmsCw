def whileLoop (condition: Boolean) (expression: Unit):Unit = {
  if(condition) {
    expression
    whileLoop(condition)(expression)
  }
}

var a = 0

def callByValue(x: Int):Unit =
{
  println("x1=" + x)
  println("x2=" + x)
}
// callByValue {a+=1; a}
//res: x1 = 1; x2 = 1


def callByName(x: => Int):Unit =
{
  println("x1=" + x)
  println("x2=" + x)
}
// callByName {a+=1; a}
//res: x1 = 1; x2 = 2

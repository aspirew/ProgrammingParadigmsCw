class Parametrized[A, B](var fst: A, var snd: B) {
  override def toString: String = {
    "(" + fst + ", " + snd + ")"
  }
}

trait Abstract{
  type A
  type B
  var fst: A
  var snd: B
}

class Abstr extends Abstract{
  type A = Int
  type B = String
  override var fst = 8
  override var snd = "Byebye"
  override def toString: String = "(" + fst + ", " + snd + ")"
}

class Pracownik(val nazwisko: String){

}

object main extends App{
  val param = new Parametrized(1, "Hello")
  param.toString
  val a = new Abstr
  a.toString
}


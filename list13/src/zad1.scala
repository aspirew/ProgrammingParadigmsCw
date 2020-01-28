// z1

class Pair[A, B](var fst: A, var snd: B) {
  override def toString: String = {
    "(" + fst + ", " + snd + ")"
  }
}

//z2

trait Abstract{
  type A
  type B
  var fst: A
  var snd: B
  override def toString: String = "(" + fst + ", " + snd + ")"
}

class AbstractPair extends Abstract{
  type A = Int
  type B = String
  override var fst = 8
  override var snd = "Byebye"
}

// z3

object Pracownik {
  private var liczbaPrac = 0
  def liczbaPracownikow(): Int = liczbaPrac
}

class Pracownik(private[this] var nazwisko: String){
  private[this] var zwolniony = false
  Pracownik.liczbaPrac += 1

  def zwolnij():Unit = {
    if(!zwolniony) {
      zwolniony = true
      Pracownik.liczbaPrac -= 1
    }
  }

  override def toString: String = {
    "Nazwisko: " + nazwisko + "\nZwolniony: " + zwolniony
  }

}

object main extends App{
//  // z1
//  val param = new Pair(1, "Hello")
//  println(param)
//
//  // z2
//  val a = new AbstractPair
//  println(a)
//
//  /// OR
//
//  val b = new Abstract() {
//    type A = Int
//    type B = String
//    override var fst = 8
//    override var snd = "Byebye"
//  }
  // println(b)

  // z3

  val prac1 = new Pracownik("Kowalski")
  val prac2 = new Pracownik("Nowak")
  val prac3 = new Pracownik("Woźniak")
  println(prac1)
  println(prac2)
  println(Pracownik.liczbaPracownikow())
  prac3.zwolnij()
  prac3.zwolnij()
  println(prac3)
  println(Pracownik.liczbaPracownikow())

}

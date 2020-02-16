//zad 1

class Time (private var h: Int = 0) {
  require(h < 24)
  if (h < 0) h = 0
  def hour: Int = h
  def hour_= (newHour: Int): Unit ={
    require(newHour < 24)
    if(newHour < 0){
      h = 0
    }
    h = newHour
  }

}

object Time {
  def apply(hour: Int) = new Time(hour)
}

// zad2

class Time2 (private var h: Int, private var m: Int){
  if (h < 0 || h >= 24) throw new IllegalArgumentException("Wrong hour range")
  if (m < 0 || m >= 60) throw new IllegalArgumentException("Wrong minute range")
  def before(other: Time2): Boolean = {
    h < other.h || h == other.h && m < other.m
  }
  def hour: Int = h
  def minute: Int = m
  def hour_= (newHour: Int): Unit = {
    if(newHour < 0 || newHour >= 24) throw new IllegalArgumentException("Wrong hour range")
    h = newHour
  }
  def minute_= (newMinute: Int): Unit = {
    if(newMinute < 0 || newMinute >= 60) throw new IllegalArgumentException("Wrong minute range")
    m = newMinute
  }
}

class Time2B (h: Int, m: Int){
  if (h < 0 || h >= 24) throw new IllegalArgumentException("Wrong hour range")
  if (m < 0 || m >= 60) throw new IllegalArgumentException("Wrong minute range")
  private var minutesAfterMidnight:Int = h * 60 + m
  def hour: Int = minutesAfterMidnight / 60
  def minute: Int = minutesAfterMidnight % 60
  def hour_=(newHour: Int): Unit = {
    if (h < 0 || h >= 24) throw new IllegalArgumentException("Wrong hour range")
    minutesAfterMidnight = minute + newHour * 60
  }
  def minute_=(newMinute:Int):Unit = {
    if (m < 0 || m >= 60) throw new IllegalArgumentException("Wrong minute range")
    minutesAfterMidnight = hour * 60 + newMinute
  }
  def before(other: Time2B): Boolean = {
    minutesAfterMidnight < other.minutesAfterMidnight
  }
}

// zad3

class Pojazd (val producent: String, val model: String, val rok: Int = -1, var rejestracja: String = ""){
  def this(producent: String, model: String, rejestracja: String){
    this(producent, model, -1, rejestracja)
  }
  def printInfo(): Unit ={
    println("Producent: " + producent)
    println("Model: " + model)
    println("Rok: " + rok)
    println("Rejestracja: " + rejestracja)
  }
}

class Auto (prod: String, mod: String, yr: Int, rej: String )
  extends Pojazd(prod, mod, yr, rej) {
    def this(producent: String, model: String){
      this(producent, model, 1234, "goowno")
  }
}

abstract class Sequence[+A] {
  def append[S>:A](x: Sequence[S]): Sequence[S]
}

object Demo {
  def main(args: Array[String]): Unit ={
    val g = Time
    val z = g.apply(4)
    println(z.hour)

    z.hour = 4

//    val t = new Time2B(23, 44)
//    val b = new Time2B(0, 17)
//    print(b.before(t))

//  new Pojazd("Fiat", "126p", 2016, "DW1234").printInfo()
//  new Pojazd("BMW", "X3", 2016).printInfo()
//  new Pojazd("Volvo", "XC60", "ZKO1203").printInfo()
//  new Pojazd("Opel", "Astra").printInfo()

    //new Auto("Audi", "A3").printInfo()

  }
}
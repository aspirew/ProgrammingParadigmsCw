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
  require(h >=0 && h < 24)
  require(m >= 0 && m < 60)
  def before(other: Time2): Boolean = {
    h < other.h || h == other.h && m < other.m
  }
  def hour: Int = h
  def minute: Int = m
  def hour_= (newHour: Int): Unit = {
    require(newHour >= 0 && newHour < 24)
    h = newHour
  }
  def minute_= (newMinute: Int): Unit = {
    require(newMinute >= 0 && newMinute < 24)
    m = newMinute
  }
}

class Time2B (h: Int, m: Int){
  require (h >= 0 && h < 24)
  require (m >= 0 && m < 60)
  private var minutesAfterMidnight:Int = h * 60 + m
  def hour: Int = minutesAfterMidnight / 60
  def minute: Int = minutesAfterMidnight % 60
  def hour_=(newHour: Int): Unit = {
    require (newHour >= 0 && newHour < 24)
    minutesAfterMidnight = minute + newHour * 60
  }
  def minute_=(newMinute:Int):Unit = {
    require(newMinute >= 0 && newMinute < 60)
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
}


object Demo {
  def main(args: Array[String]): Unit ={
//    val g = Time
//    val z = g.apply(4)
//    print(z.hour)

//    val t = new Time2B(21, 15)
//    val b = new Time2B(0, 17)
//    print(b.before(t))
  new Pojazd("Fiat", "126p", 2016, "DW1234")
  new Pojazd("Fiat", "126p", 2016)
  new Pojazd("Fiat", "126p", "ZKO1203")
  new Pojazd("Fiat", "126p")

  }
}
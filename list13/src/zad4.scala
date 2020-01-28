class Point(private var xVal: Int = 0, private var yVal: Int = 0){
  def x: Int = xVal
  def x_= (newX: Int):this.type = { xVal = newX; this }

  def y = yVal
  def y_= (newY: Int):this.type  = { yVal = newY; this }

  override def toString: String = { "(" + x + ", " + y + ")" }

}

class Circle(xVal: Int = 0, yVal: Int = 0, private var rVal: Int = 1) extends Point(xVal, yVal){
  def r: Int = rVal
  def r_= (newR: Int):this.type = { rVal = newR; this }
  override def toString: String = { "(" + x + ", " + y + ") ; " + r }
}

class Cylinder(xVal: Int = 0, yVal: Int = 0, rVal: Int = 1, private var hVal: Int = 1) extends Circle(xVal, yVal, rVal){
  def h: Int = hVal
  def h_= (newH: Int):this.type = { hVal = newH; this }
  override def toString: String = {
    "(" + x + ", " + y + ") ; " + r + " ; " + h
  }
}

object mainer extends App {
  val pnt = new Point(2, 2)
  val pnt2 = (pnt.x = 3)

  var crc = new Circle(1,5, 2)
  val cyl = new Cylinder(3,4,5,6)


  println((cyl.r = 30).h = 3)

}
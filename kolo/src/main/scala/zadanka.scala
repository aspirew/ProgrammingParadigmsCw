import java.awt.Color

class MyStack[T] (private val rep: List[T]){
  def push(x: T) = new MyStack(x::rep)
  def top = rep match {
    case x::_ => x
    case Nil => throw new Exception("xD")
  }
  def pop = rep match {
    case _::xs => new MyStack(xs)
    case Nil => this
  }
  def isEmpty = rep == Nil
}

object MyStack {
  def apply[T](xs: T*) = new MyStack[T](xs.toList.reverse)
  def empty[T]= new MyStack[T](Nil)
}

class Point(var x: Double = 0.0, var y:Double = 0.0){
  override def toString: String = s"($x,$y)"
}

class Pixel(xp: Double = 0.0, yp:Double=0.0, var color:Color = Color.BLACK)
extends Point(xp, yp){
  override def toString: String = super.toString + " " + color
}

object main extends App {
  var stackOfPoints = MyStack(new Point)
  val stackOfPoints1 = stackOfPoints.push(new Pixel(1,2))
  stackOfPoints1.top.asInstanceOf[Pixel]
  val stackOfPixels = MyStack(new Pixel(2,3))
  //stackOfPoints = stackOfPixels
}
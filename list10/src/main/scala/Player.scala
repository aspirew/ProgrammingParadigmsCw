import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.{ ask, pipe }
import scala.concurrent.Future

class Player(val id: Int, val fieldsRange: Range, var scoreField: Int) extends Actor{

  import context.dispatcher
  //val future = Future(makeMove())

  override def receive: Receive = {
    case Message(f, _) => {
      println (f)
      val fut = Future{
        makeMove()
      }
      fut pipeTo sender()
      println("SENT")
    }
  }

  def makeMove(): Int = {
    print("gimmie number: ")
    val num = scala.io.StdIn.readInt()
    num
  }

}

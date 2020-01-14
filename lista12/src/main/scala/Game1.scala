import akka.actor.{Actor, ActorRef, ActorSystem, Props}

case class Ball(from: ActorRef, count: Int)

class Player(msg: String) extends Actor{
  override def receive: Receive = {
    case Ball(_, 0) => context.system.terminate()
    case Ball(f, count) => {
      println(msg)
      f ! Ball(self, count - 1)
    }
  }
}

class Game(val player1: ActorRef, val player2: ActorRef) {
  def start(length: Int): Unit = {
      require(length >= 0)
      player1 ! Ball(player2, length)
    }
}

object Main extends App {
  val ourSystem = ActorSystem()
  val player1: ActorRef = ourSystem.actorOf(Props(classOf[Player], "Ping!"))
  val player2: ActorRef = ourSystem.actorOf(Props(classOf[Player], "Pong!"))
  val game = new Game(player1, player2)
  game.start(5)
}

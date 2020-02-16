import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class AI(id:Int, fields: Range, scoreField: Int) extends Player(id, fields, scoreField){

  override def receive: Receive = ???

  override def makeMove(): Int = {
    findBestMove()
  }

  private[this] def findBestMove(): Int = {
    4
  }

}

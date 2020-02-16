import java.util.Timer

import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

case class Message(from: ActorRef, board: Board)

class Game(val board: Board, player1: ActorRef, player2: ActorRef) extends Actor{
  var playerTurn = 0
  val players = Array(player1, player2)
  val timer = new Timer
  var movesDone = 0

  override def receive: Receive = {
    case a: Int => {
      val continue = board.moveOnBoard(a, playerTurn)
      println(continue)
      if(continue == 1) movesDone = movesDone + 1
      if(continue == 2) {
        changePlayer()
        movesDone = movesDone + 1
      }
    }
    case true => startGame(0)
    case false => startGame(1)
  }

  def waitForTurn(first: Int): Unit = {
    board.printBoard()
    playerTurn = first
    print("Turn of player " + playerTurn + ": ")
    println("sleepy")
    implicit val timeout = Timeout(10 seconds)
    val future: Future[Int] = ask(players(playerTurn), Message(self, board)).mapTo[Int]
    future.onComplete{
      case Success(value) => println(value)
      case Failure(e) => gameOver()
    }
  }

  def gameOver():Unit = {
    val winner = {
      if(board.getPlayerScore(0) > board.getPlayerScore(1)) 1
      else 2
    }
    println("Game over! The winner is player" + winner)
    System.exit(0)
  }

  def changePlayer():Unit = {
    playerTurn = (playerTurn + 1) % 2
  }

  def startGame(first: Int): Unit = {
    waitForTurn(first)
  }

}

object Main extends App {

  val ourSystem = ActorSystem()
  val player1: ActorRef = ourSystem.actorOf(Props(classOf[Player], 0, 0 to 5, 6))
  val player2: ActorRef = ourSystem.actorOf(Props(classOf[Player], 1, 7 to 12, 13))
  val gameActor: ActorRef = ourSystem.actorOf(Props(classOf[Game], new Board, player1, player2))
  gameActor ! true
}

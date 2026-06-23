package cl.uchile.dcc
package EF3.controller

import states.*

class GameController {
  // Estado actual del juego
  //Start por default
  private var state: states.GameState = new Start


  private def safeRun(op: () => Unit): Unit =
    try op()
    catch
      case e: InvalidTransitionException => println(e.getMessage)

  def setState(state: GameState): Unit =
    this.state = state


  def play(): Unit =
    safeRun(() => state.play(this))

  def start(): Unit =
    safeRun(() => state.start(this))

  def discard(): Unit =
    safeRun(() => state.discard(this))

  def end(): Unit =
    safeRun(() => state.end(this))

}



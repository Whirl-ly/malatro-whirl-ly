package cl.uchile.dcc
package EF3.controller.states

import EF3.controller.GameController

class GameState protected(){

  def changeState(context: GameController, state: GameState): Unit =
    context.setState(state)

  def start(context: GameController): Unit =
    error("start")

  def play(context: GameController): Unit =
    error("play")

  def discard(context: GameController): Unit =
    error("scoreCalculation")

  //Nota, acá puede ocurrir por victoria o por derrota,
  //pero ahí veremos que se hace
  def end(context: GameController): Unit =
    error("end")


  private def error(action: String): Nothing =
    //TO DO: aplicar implementación aquí
    throw InvalidTransitionException(action, this.toString)

  /**
   * Testing section for each GameState
   */
  def isStart: Boolean = false
  def isActiveRound: Boolean = false
  def isCardSelection: Boolean = false
  def isScoreCalculation: Boolean = false
  def isDiscarding: Boolean = false
  def isRoundEvaluation: Boolean = false
}

package cl.uchile.dcc
package EF3.controller.states

import EF3.controller.GameController

class RoundEvaluation extends GameState {

  //Te quedan turnos? Puedes seguir
  override def play(context: GameController): Unit =
    context.setState(new ActiveRound)

  //Ganaste o perdiste? Partes denuevo
  override def end(context: GameController): Unit =
    context.setState(new Start)

  override def isRoundEvaluation: Boolean = true
}

package cl.uchile.dcc
package EF3.controller.states

import EF3.controller.GameController

class Discarding extends GameState{

  // Descartaste? vuelves a jugar
  override def play(context: GameController): Unit =
    context.setState(new ActiveRound)

  override def isDiscarding: Boolean = true
}

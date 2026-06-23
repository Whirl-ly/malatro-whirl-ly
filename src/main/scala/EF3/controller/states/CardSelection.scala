package cl.uchile.dcc
package EF3.controller.states

import EF3.controller.GameController

class CardSelection extends GameState{

  override def play(context: GameController): Unit =
    context.setState(new ScoreCalculation)

  override def discard(context: GameController): Unit =
    context.setState(new Discarding)

  override def isCardSelection: Boolean = true

}

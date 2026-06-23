package cl.uchile.dcc
package EF3.controller.states

import EF3.controller.GameController

class ActiveRound extends GameState{

  override def play(context: GameController): Unit =
    context.setState(new CardSelection)

  override def isActiveRound: Boolean = true
}

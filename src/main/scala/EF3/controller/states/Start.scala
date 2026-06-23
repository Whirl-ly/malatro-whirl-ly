package cl.uchile.dcc
package EF3.controller.states

import EF3.controller.GameController

class Start extends GameState{

  override def play(context: GameController): Unit = ()

  override def start(context: GameController): Unit =
    context.setState(new ActiveRound)

  override def isStart: Boolean = true
}

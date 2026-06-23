package cl.uchile.dcc
package EF3.controller.states

import EF3.controller.GameController

class ScoreCalculation extends GameState {

  override def play(context: GameController): Unit =
    context.setState(new RoundEvaluation)

  override def isScoreCalculation: Boolean = true

}

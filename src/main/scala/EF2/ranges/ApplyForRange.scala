package cl.uchile.dcc
package EF2.ranges

import EF2.Score
import EF2.jokers.Joker

abstract class ApplyForRange extends Range{

  def applyScore(score: Score, j: Joker): Score = {
    j.applyRange(this, score)
  }

}

package cl.uchile.dcc
package EF2.ranks.figures

import EF2.ranks.Rank
import EF2.Score
import EF2.jokers.Joker
/**
 * Establishes default behavior for Figure objects
 * @note applyScore simply sends the interaction to the joker class by double-dispatch
 */
abstract class AllFigure extends Rank {
  override def classification: Object = Figure
  
  override def applyScore(score: Score, j: Joker): Score = {
    j.applyFigureRank(score)
    score

  }


}

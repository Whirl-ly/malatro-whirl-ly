package cl.uchile.dcc
package EF3.ranks.figures

import EF3.ranks.Rank
import EF3.Score
import EF3.jokers.Joker
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

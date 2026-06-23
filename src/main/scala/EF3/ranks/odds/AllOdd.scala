package cl.uchile.dcc
package EF3.ranks.odds

import EF3.ranks.Rank
import EF3.jokers.Joker
import EF3.Score
/**
 * Establishes default behavior for Odd Ranks
 * @note applyScore simply sends the interaction to the joker class by double-dispatch
 */
abstract class AllOdd extends Rank {
  override def classification: Object = Odd
  
  override def applyScore(score: Score, j: Joker): Score = {
    j.applyOddRank(score)
    score
  }

  override def hashCode(): Int = value * 31 + order

}

package cl.uchile.dcc
package EF2.ranks.odds

import EF2.ranks.Rank
import EF2.jokers.Joker
import EF2.Score
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

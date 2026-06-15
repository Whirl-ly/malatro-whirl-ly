package cl.uchile.dcc
package EF2.ranks.evens
import EF2.ranks.Rank
import EF2.Score
import EF2.jokers.Joker
/**
 * Establishes default behavior for Even objects
 * @note [[applyScore()]] simply sends the interaction to the joker class through double-dispatch
 *       by [[Joker.applyEvenRank()]]
 */
abstract class AllEven extends Rank {
  override def classification: Object = Even

  override def applyScore(score: Score, j: Joker): Score = {
    j.applyEvenRank(score)
    score
  }

  override def hashCode(): Int = value * 31 + order

}

package cl.uchile.dcc
package EF2.ranks.evens
import EF2.ranks.ApplyForRank
import EF2.Score

/**
 * Establishes default behavior for Even objects
 * @note applyScore simply sends the interaction to the joker class by double-dispatch
 */
abstract class AllEven extends ApplyForRank {
  override def classification: Object = Even

  override def applyEvenJoker(score: Score): Unit = {
    score.multiplier_(score.multiplier + 4)
  }
}

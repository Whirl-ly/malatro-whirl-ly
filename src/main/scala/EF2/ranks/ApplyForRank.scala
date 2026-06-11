package cl.uchile.dcc
package EF2.ranks

import EF2.Score
import EF2.jokers.Joker
/**
 * Establishes default behavior for the majority of Rank objects
 * @note applyScore simply sends the interaction to the joker class by double-dispatch
 * @see [[Joker.applySuit() Joker behavior with rangks]]
 */
abstract class ApplyForRank extends Rank{

  def applyScore(score: Score, j: Joker): Score = {
    j.applyRange(this, score)
  }
  override def applyEvenJoker(score: Score): Unit = {}
  override def applyScaryFace(score: Score): Unit = {}
}

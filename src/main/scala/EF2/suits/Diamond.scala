package cl.uchile.dcc
package EF2.suits

import EF2.Score
/**
 * Diamond (type of suit) representation
 */
class Diamond extends applyForSuit{
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Diamond]

  override def hashCode(): Int = getClass.hashCode()

  /**
   * Increments the score multiplier by 3 only in this case 
   * @param score score to modify
   */
  override def applyGreedyJoker(score: Score): Unit = {
    score.multiplier_(score.multiplier + 3)
  }
}

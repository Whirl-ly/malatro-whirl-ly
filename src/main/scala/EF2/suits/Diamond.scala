package cl.uchile.dcc
package EF2.suits

import EF2.Score
import EF2.jokers.Joker
/**
 * Diamond (type of suit) representation
 */
class Diamond extends applyForSuit{
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Diamond]



  /**
   * Redefines the behavior of the score update when a Diamond Suit interacts
   * with a Joker Card by doing [[Joker.applyDiamond()]]
   *
   * @param score Score to update
   * @param j     Joker to interact with
   * @return      Updated score
   */
  override def applyScore(score: Score, j: Joker): Score = {
    j.applyDiamond(score)
    score
  }
}

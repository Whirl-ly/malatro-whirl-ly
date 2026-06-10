package cl.uchile.dcc
package EF2.jokers

import EF2.combinations.Combination
import EF2.Score

/**
 * Representation of DeviousJoker (type of joker)
 */
class DeviousJoker extends JokerApply {
  override def equals(obj: Any): Boolean=
    obj.isInstanceOf[DeviousJoker]

  override def hashCode(): Int = getClass.hashCode()

  override def applyCombination(cCombination: Combination, score: Score): Score = {
    cCombination.applyDeviousJoker(score)
    score
  }
}

package cl.uchile.dcc
package EF2.jokers

import EF2.Score
import EF2.ranges.*
import EF2.ranges.evens.AllEven
/**
 * Representation of evenJoker (type of joker)
 */
class EvenJoker extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[EvenJoker]

  override def hashCode(): Int = getClass.hashCode()

  override def applyRange(cRange: Range, score: Score): Score = {
    cRange.applyEvenJoker(score)
    score
  }
}

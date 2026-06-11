package cl.uchile.dcc
package EF2.jokers

import EF2.Score
import EF2.ranks.*
import EF2.ranks.evens.AllEven
/**
 * Representation of evenJoker (type of joker)
 */
class EvenJoker extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[EvenJoker]

  override def hashCode(): Int = getClass.hashCode()

  override def applyRange(cRank: Rank, score: Score): Score = {
    cRank.applyEvenJoker(score)
    score
  }
}

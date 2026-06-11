package cl.uchile.dcc
package EF2.jokers

import EF2.Score
import EF2.ranks.Rank
/**
 * Representation of scaryFace (type of joker)
 */
class ScaryFace extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[ScaryFace]

  override def hashCode(): Int = getClass.hashCode()

  override def applyRange(cRank: Rank, score: Score): Score = {
    cRank.applyScaryFace(score)
    score
  }
}

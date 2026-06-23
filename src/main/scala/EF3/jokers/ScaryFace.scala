package cl.uchile.dcc
package EF3.jokers

import EF3.Score

/**
 * Representation of scaryFace (type of joker)
 * @note Only interacts with Figure Ranks
 */
class ScaryFace extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[ScaryFace]



  /**
   * Special interaction between ScaryFace and Figure Ranks:
   *
   * +30 to score chips
   *
   * @param score Score to update
   * @return Updated score
   */
  override def applyFigureRank(score: Score): Score = {
    score.chips_(score.chips + 30)
    score
  }
}

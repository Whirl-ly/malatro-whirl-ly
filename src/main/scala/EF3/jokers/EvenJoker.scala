package cl.uchile.dcc
package EF3.jokers

import EF3.Score

/**
 * Representation of EvenJoker (type of joker)
 * @note Only interacts with Even Ranks
 */
class EvenJoker extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[EvenJoker]



  /**
   * Special interaction between EvenJoker and Even Ranks:
   *
   *  +4 to score multiplier
   *
   * @param score Score to update
   * @return Updated score
   */
  override def applyEvenRank(score: Score): Score = {
    score.multiplier_(score.multiplier + 4)
    score
  }
}

package cl.uchile.dcc
package EF2.jokers

import EF2.Score

/**
 * Representation of DeviousJoker (type of joker)
 * @note Only interacts with Straight Combinations
 */
class DeviousJoker extends JokerApply {
  override def equals(obj: Any): Boolean=
    obj.isInstanceOf[DeviousJoker]



  /**
   * Special interaction between DeviousJoker and Straight Combinations:
   *
   * +100 to score chips
   *
   * @param score score to update
   * @return updated score
   */
  override def applyStraight(score: Score): Score = {
    score.chips_(score.chips + 100)
    score
  }
}

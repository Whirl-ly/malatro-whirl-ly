package cl.uchile.dcc
package EF3.jokers
import EF3.Score
/**
 * Representation of GreedyJoker (type of joker)
 * @note Only interacts with Diamond Suits
 */
class GreedyJoker extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[GreedyJoker]



  /**
   * Special interaction between GreedyJokers and Diamonds:
   *
   * +3 to score multiplier
   * @param score Score to update
   * @return Updated score
   */
  override def applyDiamond(score: Score): Score = {
    score.multiplier_(score.multiplier + 3)
    score 
  }
}

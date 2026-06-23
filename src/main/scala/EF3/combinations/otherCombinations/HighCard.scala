package cl.uchile.dcc
package EF3.combinations.otherCombinations

import EF3.combinations.CombinationBase
import EF3.{Card, Score}
/**
 * Represents a list cards that doesn't align with any of the other type of
 * combinations
 */
class HighCard extends CombinationBase{
  override val priority: Int = 0
  override val bScore: Score = new Score(5,1)
  override def validate(cards: List[Card]): Boolean = {

    !isStraight(cards) && !sameSuit(cards) &&
    !sameRank(cards, 2) && !sameRank(cards,3)

  }

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[HighCard]
}

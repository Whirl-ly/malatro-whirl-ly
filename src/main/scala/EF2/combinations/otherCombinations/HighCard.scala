package cl.uchile.dcc
package EF2.combinations.otherCombinations

import EF2.combinations.CombinationBase
import EF2.{Card, Score}
/**
 * Represents a list cards that doesn't align with any of the other type of
 * combinations
 */
class HighCard extends CombinationBase{
  override val bScore: Score = new Score(5,1)
  override def validate(cards: List[Card]): Boolean = {

    !isStraight(cards) && !sameSuit(cards) &&
    !sameRange(cards, 2) && !sameRange(cards,3)

  }

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[HighCard]
}

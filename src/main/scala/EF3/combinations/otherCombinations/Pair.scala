package cl.uchile.dcc
package EF3.combinations.otherCombinations

import EF3.combinations.CombinationBase
import EF3.{Card, Score}

/**
 * Represents a list of cards that has two of them with the same rank
 */
class Pair extends CombinationBase {
  override val priority: Int = 60
  override val bScore: Score = new Score(10, 2)
  override def validate(cards: List[Card]): Boolean = {
    sameRank(cards, 2)
  }

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Pair]
}
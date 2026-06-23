package cl.uchile.dcc
package EF3.combinations.otherCombinations

import EF3.combinations.CombinationBase
import EF3.{Card, Score}

/**
 * Represents a list of cards that has three cards with the same rank
 */
class Trio extends CombinationBase {
  override val priority: Int = 70
  override val bScore: Score = new Score(30, 3)
  override def validate(cards: List[Card]): Boolean =
    sameRank(cards, 3)


  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Trio]
}

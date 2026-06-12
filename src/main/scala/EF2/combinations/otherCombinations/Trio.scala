package cl.uchile.dcc
package EF2.combinations.otherCombinations

import EF2.combinations.CombinationBase
import EF2.{Card, Score}

/**
 * Represents a list of cards that has three cards with the same rank
 */
class Trio extends CombinationBase {
  override val bScore: Score = new Score(30, 3)
  override def validate(cards: List[Card]): Boolean =
    sameRange(cards, 3)


  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Trio]
}

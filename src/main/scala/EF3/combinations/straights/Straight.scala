package cl.uchile.dcc
package EF3.combinations.straights

import EF3.{Card, Score}

/**
 * Represents a list of five cards in consecutive order, regardless of suit
 */
class Straight extends ApplyForStraights {
  override val priority: Int = 80
  override val bScore: Score = new Score(30,4)
  override def validate(cards: List[Card]): Boolean =
    isStraight(cards)

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Straight]
}

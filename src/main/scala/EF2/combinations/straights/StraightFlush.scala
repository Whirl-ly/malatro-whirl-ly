package cl.uchile.dcc
package EF2.combinations.straights

import EF2.{Card, Score}

/**
 * Represents a list of five cards in consecutive order with the same suit
 */
class StraightFlush extends ApplyForStraights {
  override val bScore: Score = new Score(100,8)
  override def validate(Cards: List[Card]): Boolean =
    sameSuit(Cards) && isStraight(Cards)

}

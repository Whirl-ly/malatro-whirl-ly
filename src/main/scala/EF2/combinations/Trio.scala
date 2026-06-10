package cl.uchile.dcc
package EF2.combinations

import EF2.{Card, Score}

/**
 * Represents a list of cards that has three cards with the same range 
 */
class Trio extends CombinationBase {
  override val pBase: Score = new Score(30, 3)
  override def validate(cards: List[Card]): Boolean =
    sameRange(cards, 3)
}

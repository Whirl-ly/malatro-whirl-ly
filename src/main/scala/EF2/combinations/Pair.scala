package cl.uchile.dcc
package EF2.combinations

import EF2.{Card, Score}

/**
 * Represents a list of cards that has two of them with the same range 
 */
class Pair extends CombinationBase {
  override val pBase: Score = new Score(10, 2)
  override def validate(cards: List[Card]): Boolean = {
    sameRange(cards, 2)
  }
}
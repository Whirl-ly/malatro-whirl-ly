package cl.uchile.dcc
package EF2.combinations
import EF2.{Card, Score}

/**
 * Represents a list of five cards in consecutive order, regardless of suit
 */
class Straight extends CombinationBase{
  override val pBase: Score = new Score(30,4)
  override def validate(cards: List[Card]): Boolean =
    isStraight(cards)
}

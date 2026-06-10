package cl.uchile.dcc
package EF2.combinations
import EF2.{Card, Score}
/**
 * Represents a list of five cards with the same suit, regardless of order
 */
class ColorFlush extends CombinationBase{
  override val pBase: Score = new Score(35, 4)
  override def validate(cards: List[Card]): Boolean =
    sameSuit(cards)
}

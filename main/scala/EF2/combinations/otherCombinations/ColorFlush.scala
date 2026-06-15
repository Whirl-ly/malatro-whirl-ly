package cl.uchile.dcc
package EF2.combinations.otherCombinations

import EF2.combinations.CombinationBase
import EF2.{Card, Score}
/**
 * Represents a list of five cards with the same suit, regardless of order
 */
class ColorFlush extends CombinationBase{
  override val priority: Int = 90
  override val bScore: Score = new Score(35, 4)
  override def validate(cards: List[Card]): Boolean =
    sameSuit(cards)


  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[ColorFlush]
}

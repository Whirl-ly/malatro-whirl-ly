package cl.uchile.dcc
package EF2.combinations
import EF2.{Card,Score}

/**
 * Represents a list of five cards in consecutive order with the same suit
 */
class StraightFlush extends CombinationBase{
  override val pBase: Score = new Score(100,8)
  override def validate(Cards: List[Card]): Boolean =
    sameSuit(Cards) && isStraight(Cards)

  override def applyDeviousJoker(score: Score): Unit = {
    score.chips_(score.chips + 100)
  }
}

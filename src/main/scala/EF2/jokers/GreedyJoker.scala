package cl.uchile.dcc
package EF2.jokers
import EF2.Score
import EF2.suits.Suit
/**
 * Representation of greedyJoker (type of joker) 
 */
class GreedyJoker extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[GreedyJoker]

  override def hashCode(): Int = getClass.hashCode()

  override def applySuit(cSuit: Suit, score: Score): Score = {
    cSuit.applyGreedyJoker(score)
    score 
  }
}

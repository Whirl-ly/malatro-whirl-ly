package cl.uchile.dcc
package EF2.suits
import EF2.Score
import EF2.jokers.*

/**
 * Establishes default behavior for the majority of suits 
 * @note applyScore simply sends the interaction to the joker class by double-dispatch
 * @see [[Joker.applySuit() Joker behavior with suits]]
 */
abstract class applyForSuit extends Suit{
  override def applyScore(score: Score, j: Joker): Score = {
    j.applySuit(this, score)
  }


  override def applyGreedyJoker(score: Score): Unit = {}
  
}

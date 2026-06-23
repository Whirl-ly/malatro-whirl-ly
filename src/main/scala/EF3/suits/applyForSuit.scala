package cl.uchile.dcc
package EF3.suits
import EF3.Score
import EF3.jokers.*

/**
 * Establishes default interaction behavior between the majority of Suits and Jokers through double-dispatch
 *
 * @see [[Joker.applyOtherSuit() How applyOtherSuit() works]]
 *
 */
abstract class applyForSuit extends Suit{
  override def applyScore(score: Score, j: Joker): Score = {
    j.applyOtherSuit(score)
    score
  }
}

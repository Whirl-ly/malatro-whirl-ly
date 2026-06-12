package cl.uchile.dcc
package EF2.suits
import EF2.Score
import EF2.jokers.*

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

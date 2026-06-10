package cl.uchile.dcc
package EF2.suits
import EF2.Score
import EF2.jokers.*

abstract class applyForSuit extends Suit{
  
  def applyScore(score: Score, j: Joker): Score = {
    j.applySuit(this, score)
  }

  /**
   * Applies the effect of a Greedy Joker card on suits
   * 
   * @note does nothing most of the time
   * @param score score to modify
   * @see applySuit on Joker Class and Diamond Class
   */
  override def applyGreedyJoker(score: Score): Unit = {}
  
}

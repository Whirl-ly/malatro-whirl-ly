package cl.uchile.dcc
package EF2.suits
import EF2.Score
import EF2.jokers.Joker
/**
 * A simple pinta (from a card) abstraction
 * 
 * Helps to classify a card
 * @see [[EF2.Card How Card class works]]
 */
trait Suit {
  
  /**
   * Compares two types of suit
   * @param obj object to compare
   * @return true if suits are the same / false if not
   */
  def equals(obj: Any): Boolean

  /**
   *  Updates score points based on the interaction between Joker and Suit classes 
   * @param score score to update
   * @param j joker to interact with
   * @return new score (puntaje type)
   * @see [[applyForSuit applyForSuit abstract class for default behavior]]
   */
  def applyScore(score: Score, j: Joker): Score
  
  /**
   * Generates unique ID to a suit
   * @return ID number
   */
  def hashCode(): Int

  /**
   * Applies the effect of a GreedyJoker card on suits
   *
   * @note does nothing most of the time
   * @param score score to modify
   * @see [[Diamond.applyGreedyJoker() Diamond Card interaction with GreedyJoker]]
   * @see [[Joker.applySuit() applySuit method]]
   */
  def applyGreedyJoker(score:Score): Unit
}

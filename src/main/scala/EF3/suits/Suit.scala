package cl.uchile.dcc
package EF3.suits
import EF3.Score
import EF3.jokers.Joker
/**
 * A simple pinta (from a card) abstraction
 * 
 * Helps to classify a card
 *
 * @see [[EF3.Card How Card class works]]
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

}

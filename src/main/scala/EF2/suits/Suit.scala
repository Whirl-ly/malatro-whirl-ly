package cl.uchile.dcc
package EF2.suits
import EF2.Score
import EF2.jokers.Joker
/**
 * A simple pinta (from a card) abstraction
 * 
 * Helps to classify a card
 * @see carta class
 */
trait Suit {
  /**
   * Compares two types of suit
   * @param obj object to compare
   * @return true if suits are the same / false if not
   */
  def equals(obj: Any): Boolean

  /**
   *  Updates score points depending on a certain predisposed joker type,
   *  range and suit from the card
   * @param score represents a predisposed score
   * @param j represents a predisposed joker
   * @return new score (puntaje type)
   */
  def applyScore(score: Score, j: Joker): Score
  /**
   * Generates unique ID to a suit
   * @return ID number
   */
  def hashCode(): Int
}

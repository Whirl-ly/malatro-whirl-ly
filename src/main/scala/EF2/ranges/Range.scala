package cl.uchile.dcc
package EF2.ranges

import EF2.Score
import EF2.jokers.Joker

/**
 * A simple range (from a card) abstraction.
 * 
 * Helps to classify a card
 *
 * @see Card class
 */
trait Range {
  // The next 3 functions are abstract getters 
  /** Value of the card (ex: a "King" has a value of 10 */
  def value: Int
  /** Order of the card inside the deck  */
  def order: Int
  /** Can be "Pair", "Odd" or "Figure" (objects) */
  def clasification: Object

  /**
   * Compares two types of range
   * @param obj object to compare
   * @return true if ranges are the same / false if not
   */
  def equals(obj:Any): Boolean

  def applyScore(score: Score, j: Joker): Score
  /**
   * Generates unique ID to a range
   *
   * @return ID number
   */
  def hashCode(): Int
  
  def applyEvenJoker(score:Score) : Unit
  def applyScaryFace(score: Score): Unit
}

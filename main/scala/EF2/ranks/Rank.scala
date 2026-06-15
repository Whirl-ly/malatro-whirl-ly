package cl.uchile.dcc
package EF2.ranks

import EF2.Score
import EF2.jokers.Joker

/**
 * A simple rank (from a card) abstraction.
 * 
 * Helps to classify a card
 *
 * @see [[EF2.Card How Card class works]]
 */
trait Rank {
  // The next 3 functions are abstract getters 
  /**
   * Value of the card
   *  @example a "King" has a value of 10
   */
  def value: Int
  /**
   *  Order of the card inside the deck
   *  @example Jack has an order of 11
   *  @example Queen has an order of 12
   */
  def order: Int
  /**
   * Represents the classification of a card determined by its object type or value
   * Can be Pair, Odd or Figure (objects)
   *
   * @example Four is Even
   * @example Queen is Figure
   * @example Ace is Odd
   * @see [[EF2.ranks.evens.Even Even Object]]
   * @see [[EF2.ranks.odds.Odd Odd Object]]
   * @see [[EF2.ranks.figures.Figure Figure Object]]
   */
  def classification: Object

  /**
   * Compares two types of rank
   * @param obj Object to compare
   * @return True if ranks are the same / false if not
   */
  def equals(obj:Any): Boolean

  /**
   * Allows score points to update based on the interaction between jokers and ranks by double-dispatch
   *
   * @param score Predisposed score to update
   * @param j Joker to interact with
   * @return Updated score
   */
  def applyScore(score: Score, j: Joker): Score

  /**
   * Generates unique ID to a rank
   *
   * @return ID number
   */
  def hashCode(): Int
}

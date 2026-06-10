package cl.uchile.dcc
package EF2.jokers

import EF2.Score
import EF2.ranges.Range
import EF2.suits.Suit
import EF2.combinations.Combination
import EF2.Card
/**
 * Simple joker (type of card) abstraction
 */
trait Joker {
  /**
   * Compares two types of jokers
   *
   * @param obj object to compare
   * @return true if jokers are the same / false if not
   */
  def equals(obj: Any): Boolean

  /**
   * Generates unique ID to a joker
   *
   * @return ID number
   */
  def hashCode(): Int

  def applyRange(cRange: Range, score: Score): Score

  def applySuit(cSuit: Suit, score: Score): Score

  def applyCombination(cCombination: Combination, score: Score): Score
  
  def applyCard(card: Card, score: Score): Score
}
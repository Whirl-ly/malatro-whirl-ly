package cl.uchile.dcc
package EF2.jokers

import EF2.Score
import EF2.ranks.Rank
import EF2.suits.Suit
import EF2.combinations.Combination
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

  def applyRange(cRank: Rank, score: Score): Score

  def applySuit(cSuit: Suit, score: Score): Score

  def applyCombination(cCombination: Combination, score: Score): Score
}
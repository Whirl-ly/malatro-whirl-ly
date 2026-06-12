package cl.uchile.dcc
package EF2.jokers

import EF2.Score
/**
 * Simple joker (type of card) abstraction.
 * 
 * It includes expected behavior when interacting with properties of a Card/Hand of cards
 */
trait Joker {
  /**
   * Compares two types of jokers
   *
   * @param obj Object to compare
   * @return True if jokers are the same / false if not
   */
  def equals(obj: Any): Boolean


  /**
   * Defines the interaction between Jokers and Even Ranks
   * @param score Score to update
   * @return Updated score
   * @note [[EvenJoker.applyEvenRank() EvenJoker interaction with Even Ranks]]
   * @note [[JokerApply Default behavior]]
   */
  def applyEvenRank(score: Score): Score

  /**
   * Defines the interaction between Jokers and Figure Ranks
   *
   * @param score Score to update
   * @return Updated score
   * @see [[ScaryFace.applyFigureRank() ScaryFace interaction with Figure Ranks]]
   * @see [[JokerApply Default behavior]]
   */
  def applyFigureRank(score: Score): Score

  /**
   * Defines the interaction between Jokers and Odd Ranks
   *
   * @param score Score to update
   * @return Updated score
   * @note No special behavior needed
   * @see [[JokerApply Default behavior]]
   */
  def applyOddRank(score:Score): Score

  /**
   * Defines the interaction between Jokers and Diamond Suits
   *
   * @param score Score to update
   * @return Updated score
   * @see [[GreedyJoker.applyDiamond() GreedyJoker interaction with a Diamond Suit]]
   * @see [[JokerApply Default behavior]]
   */
  def applyDiamond(score: Score): Score

  /**
   * Defines the interaction between Jokers and Other Suits
   *
   * @param score Score to update
   * @return Updated score
   * @note No special behavior needed
   * @see [[JokerApply Default behavior]]
   */
  def applyOtherSuit(score: Score): Score

  /**
   * Defines the interaction between Jokers and Straight Combinations
   * 
   * @param score Score to update
   * @return Updated score
   * @see [[DeviousJoker.applyStraight() DeviousJoker interaction with a Straight Combination]]
   * @see [[JokerApply Default behavior]]
   */
  def applyStraight(score: Score): Score

  /**
   * Defines the interaction between Jokers and Other Combinations
   * @param score Score to update
   * @return Updated score
   * @see [[JokerApply Default behavior]]
   */
  def applyOtherCombination(score: Score): Score
}
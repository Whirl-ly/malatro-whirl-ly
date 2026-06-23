package cl.uchile.dcc
package EF3.combinations
import EF3.{Card, Score}
import EF3.jokers.*

/**
 * A simple abstraction of a combination (from a poker combination) 
 */
trait Combination {

  /**
   * Represent's the priority of the combination.
   * It's useful to resolve conflictive combination's in a hand
 *
   * @see [[EF3.hand.ResolveHand How conflictive combinations are solved in a hand]]
   */
  val priority: Int

  /** Base score of the combination
   * @see [[Score Score class]] */
  val bScore: Score

  /**
   * Validates if a list of cards corresponds to a type of combination
   * @param Cards list of cards
   * @return true if it is a [class] combination/ false if not
   * @see [[otherCombinations.HighCard HighCard class validation process as an example]]
   */
  def validate(Cards: List[Card]): Boolean
  
  /**
   * Allows score points to update based on the interaction between jokers and combinations by double-dispatch
   *
   * @param score predisposed score
   * @param j joker to interact with
   * @return updated score
   * @note By default, all combinations sends the dispatch to Jokers with "j.applyOtherCombination()" 
   * @see [[EF3.combinations.straights.ApplyForStraights.applyScore() Special behavior between Straight Combinations and Jokers]]
   */
  def applyScore(score: Score, j: Joker): Score


  /**
   * Compares two types of Combination
   * @param obj Object/Class to compare
   * @return True if Combinations are the same / false if not
   */
  def equals(obj: Any): Boolean

}

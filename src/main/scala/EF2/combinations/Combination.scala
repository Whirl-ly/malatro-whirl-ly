package cl.uchile.dcc
package EF2.combinations
import EF2.{Card,Score}
import EF2.jokers.*

/**
 * A simple abstraction of a combination (from a poker combination) 
 */
trait Combination {
  /** Base score of the combination 
   * @see Score class */
  val pBase: Score

  /**
   * Validates if a list of cards corresponds to a type of combination    
   * @param Cards list of cards
   * @return true if it is a [class] combination/ false if not
   * @see HighCard class as an example
   */
  def validate(Cards: List[Card]): Boolean

  /**
   * Updates score points based in a DeviousJoker card application
   * and a combination
   *
   * @param score represents a predisposed score
   * @note does nothing most of the time
   * @see applyCombination method on JokerApply class
   */
  def applyDeviousJoker(score: Score): Unit

  /**
   * Allows score points update based on certain joker type by double-dispatch
   *
   * @param score predisposed score
   * @param j predisposed joker type
   * @return updated score
   */
  def applyScore(score: Score, j: Joker): Score
}

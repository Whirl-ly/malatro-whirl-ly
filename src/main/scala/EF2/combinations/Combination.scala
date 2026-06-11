package cl.uchile.dcc
package EF2.combinations
import EF2.{Card,Score}
import EF2.jokers.*

/**
 * A simple abstraction of a combination (from a poker combination) 
 */
trait Combination {
  /** Base score of the combination 
   * @see [[Score Score class]] */
  val bScore: Score

  /**
   * Validates if a list of cards corresponds to a type of combination    
   * @param Cards list of cards
   * @return true if it is a [class] combination/ false if not
   * @see [[HighCard HighCard class validation process as an example]]
   */
  def validate(Cards: List[Card]): Boolean

  /**
   * Updates score points based in a DeviousJoker interaction with a combination
   *
   * @param score represents a predisposed score
   * @note default behavior: does nothing
   * @note special behavior: adds 100 chips when interacting with straights
   * @see [[EF2.jokers.JokerApply.applyCombination() applyCombination method]] 
   * @see [[straights.ApplyForStraights ApplyForStraights abstract class]]
   */
  def applyDeviousJoker(score: Score): Unit

  /**
   * Allows score points to update based on the interaction between jokers and combinations by double-dispatch
   *
   * @param score predisposed score
   * @param j joker to interact with
   * @return updated score
   */
  def applyScore(score: Score, j: Joker): Score
}

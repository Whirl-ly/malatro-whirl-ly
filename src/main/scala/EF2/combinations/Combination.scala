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
   * Updates score points depending on a certain predisposed joker type
   * and a combination
   *
   * @param score represents a predisposed score
   * @param j     represents a predisposed joker
   * @return new score  
   */
  def applyScore(score: Score, j: Joker): Score
}

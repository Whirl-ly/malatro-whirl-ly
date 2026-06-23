package cl.uchile.dcc
package EF3.combinations.straights

import EF3.combinations.CombinationBase
import EF3.Score
import EF3.jokers.Joker

/**
 * Applies the score of a Straight type of Combination 
 * when interacting with Jokers
 *
 * @see [[EF3.jokers.JokerApply JokerApply abstract class]]
 */
abstract class ApplyForStraights extends CombinationBase {
  /**
   * Redefines the behavior of the score update when a Straight type of Combination interacts
   * with a Joker Card by doing [[Joker.applyStraight()]]
   * @param score Score to update
   * @param j Joker to interact with
   * @return Updated score
   */
  override def applyScore(score: Score, j: Joker): Score = {
    j.applyStraight(score)
    score
  }


  
  
}

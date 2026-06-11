package cl.uchile.dcc
package EF2.combinations.straights

import EF2.combinations.CombinationBase
import EF2.Score

/**
 * Applies the score of a Straight type of Combination 
 * when interacting with a DeviousJoker
 * @see [[EF2.jokers.JokerApply JokerApply abstract class]]
 */
abstract class ApplyForStraights extends CombinationBase {
    
  override def applyDeviousJoker(score: Score): Unit = {
    score.chips_(score.chips + 100)
  }
  
}

package cl.uchile.dcc
package EF3.hand

import EF3.Card
import EF3.combinations.straights.{Straight, StraightFlush}
import EF3.combinations.*
import EF3.combinations.otherCombinations.*

/**
 * Resolves simple cases of conflict from a hand of cards that aligns with multiple type of
 * combinations.
 *
 * @note The criteria used to determine the combination follows the priority list below:
 *       
 * 1. StraightFlush
 * 2. ColorFlush
 * 3. Straight
 * 4. Trio
 * 5. Pair
 * 6. HighCard
 *
 */
class ResolveHand extends ValidateAction {

  private val allCombinations: List[Combination] = List(
    new StraightFlush,
    new ColorFlush,
    new Straight,
    new Trio,
    new Pair,
    new HighCard
  )

  /**
   * Sets combination in a conflictive hand of cards.
   *
   * @param Cards hand of cards
   * @return a Combination
   * @example List(LowAceP, TwoP, ThreeP, FourP, FiveP) is a hand of cards which
   *          classifies as a "StraightFlush" instead of "ColorFlush" or "Straight".
   * @see [[EF3.combinations.straights Straight Combinations]]
   * @see [[EF3.combinations.otherCombinations Other Combinations]]
   */
  def determineCombination(Cards: List[Card]) : Combination = {
    allCombinations
      .filter(c => c.validate(Cards)) //Determine combinations in hand
      .maxByOption(_.priority).get  //Select the one with the max priority
  }

}

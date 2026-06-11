package cl.uchile.dcc
package EF2.hand

import EF2.Card
import EF2.combinations.straights.{Straight, StraightFlush}
import EF2.combinations.*

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
  private val straightFlush = new StraightFlush
  private val color = new ColorFlush
  private val straight = new Straight
  private val tri = new Trio
  private val pair = new Pair
  private val highCard = new HighCard

  /**
   * Sets combination in a conflictive hand of cards.
   *
   * @param Cards hand of cards
   * @return a Combination 
   *
   * @example List(LowAceP, TwoP, ThreeP, FourP, FiveP) is a hand of cards which
   *          classifies as a "StraightFlush" instead of "ColorFlush" or "Straight".
   *
   * @see [[EF2.combinations Types of combination]]
   */
  def determineCombination(Cards: List[Card]) : Combination = {
    if (straightFlush.validate(Cards)) straightFlush
    else if (color.validate(Cards)) color
    else if (straight.validate(Cards)) straight
    else if (tri.validate(Cards)) tri
    else if (pair.validate(Cards)) pair
    else highCard
    
  }

}

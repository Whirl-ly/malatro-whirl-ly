package cl.uchile.dcc
package EF2.combinations
import EF2.Card

/**
 * Resolves simple cases of conflict from a hand of cards that aligns with multiple type of
 * combinations.
 *
 * The criteria used to determine the combination follow the priority list below:
 * 1. StraightFlush
 * 2. ColorFlush
 * 3. Straight
 * 4. Trio
 * 5. Pair
 * 6. HighCard
 *
 */
class ResolveHand {
  private val straightFlush = new StraightFlush
  private val color = new ColorFlush
  private val straight = new Straight
  private val tri = new Trio
  private val pair = new Pair
  private val highCard = new HighCard

  /**
   * Sets combination in a conflictive list of cards.
   *
   * @param Cards list of cards
   * @return combination
   *
   * @example List(LowAceP, TwoP, ThreeP, FourP, FiveP) is a hand of cards which
   *          classifies as a "StraightFlush" instead of "ColorFlush" or "Straight".
   *
   * @see combinationsTest
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

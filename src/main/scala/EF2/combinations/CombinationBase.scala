package cl.uchile.dcc
package EF2.combinations
import EF2.{Card, Score}
import EF2.jokers.*
/**
 * Contains all the base functions used in concrete classes inside combinations package
 *
 */
abstract class CombinationBase extends Combination{
  /**
   * Verifies if all the cards inside Cards has the same suit
   *
   * @param Cards List of cards (its length has to be 5)
   * @return true if all the cards are the same suit / false if not
   */
  protected def sameSuit(Cards:List[Card]): Boolean = {
    Cards.length == 5 &&
    Cards.forall(_.suit == Cards.head.suit)
  }

  /**
   * Checks if five cards inside list are consecutive
   * by checking the order of each one
   *
   * @param Cards List of Cards
   * @return True if the cards are consecutive / false if not
   * @note returns false if the List don't have a proper length
   * @note Solves the duality of the Ace Rank behavior present in a Straight
   */
  protected def isStraight(Cards:List[Card]): Boolean = {
    if (Cards.length != 5) return false

    val sortedOrders = Cards.map(_.rank.order).sorted
    //This case solves LowAce issues (and everything else)
    val isNormalStraight = (0 until sortedOrders.length - 1).forall(i => sortedOrders(i+1) == sortedOrders(i) + 1)

    //This case only solves HighAce issues
    val isAceLowStraight = sortedOrders.head == 1 && {
      val withHighAce = (sortedOrders.tail :+ 14).sorted
      (0 until withHighAce.length - 1).forall(i => withHighAce(i + 1) == withHighAce(i) + 1)
    }
    isNormalStraight || isAceLowStraight
  }
  /**
   * Checks if the cards inside the list
   * has at least one group of cards with the same rank
   *
   * @param Cards List of cards (Cards.length>= n)
   * @param n Minimum group size
   * @return True if a group of cards with same rank exists / false if not
   */
  protected def sameRange(Cards:List[Card], n:Int): Boolean = {
    Cards.length <= 5 && Cards.length >= n &&
      Cards.groupBy(_.rank).values.exists(grupo => grupo.length >= n)
  }
  
  def applyScore(score: Score, j: Joker): Score = {
    j.applyOtherCombination(score)
    score
  }

}

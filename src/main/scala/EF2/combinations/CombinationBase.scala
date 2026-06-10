package cl.uchile.dcc
package EF2.combinations
import EF2.{Card, Score}
import EF2.jokers.*
/**
 * Contains all the base functions used in concrete classes inside combinaciones package
 * 
 * (resolves code duplication)
 */
abstract class CombinationBase extends Combination{
  /**
   * Verifies if all the cards inside Cards has the same suit
   *
   * @param Cards list of cards (its length has to be 5)
   * @return true if all the cards are the same suit / false if not
   */
  protected def sameSuit(Cards:List[Card]): Boolean = {
    Cards.length == 5 &&
    Cards.forall(_.suit == Cards.head.suit)
  }

  /**
   * Checks if the cards inside the list are consecutive
   * by checking the order of each one
   *
   * @param Cards list of cards
   * @return true if the cards are consecutive / false if not
   */
  protected def isStraight(Cards:List[Card]): Boolean = {
    val ordenes = Cards.map(_.range.order).sorted
    (0 until ordenes.length - 1).forall(i => ordenes(i+1) == ordenes(i) + 1)
  }
  /**
   * Checks if the cards inside the list
   * has at least one group of cards with the same range
   * @param Cards list of cards (cartas.length>= n)
   * @param n minimum group size
   * @return true if a group of cards with same range exists / false if not
   */
  protected def sameRange(Cards:List[Card], n:Int): Boolean = {
    Cards.length <= 5 && Cards.length >= n &&
      Cards.groupBy(_.range).values.exists(grupo => grupo.length >= n)
  }

  override def applyDeviousJoker(score: Score): Unit = {}

  def applyScore(score: Score, j: Joker): Score = {
    j.applyCombination(this, score)
  }
}

package cl.uchile.dcc
package EF2
import suits.Suit
import ranges.Range
import jokers.*
/**
 * Represents a card defined by its range and suit
 * @param _range range of the card
 * @param _suit suit of the card
 */
class Card(private val _range: Range, private val _suit: Suit) {
 
  /* getters */
  def range: Range = _range
  def suit: Suit = _suit

  
  /**
   * Compares two cards through its attributes
   *
   * @param obj object to compare
   * @return true if cards are the same / false if not
   */

  override def equals(obj:Any): Boolean =
    if obj.isInstanceOf[Card] then
      val other = obj.asInstanceOf[Card]
      this.range == other.range && this.suit == other.suit
    else
      false

  /**
   * Generates unique ID to a card
   * @return ID number
   */
  override def hashCode(): Int =
    range.hashCode() * 31 + suit.hashCode()
  
  def applyScore(score: Score, Jokers: List[Joker]): Score = {
    val final_score: Score = score
    for (j <- Jokers) {
      j.applyCard(this, final_score)
    }
    final_score
  }
  
}

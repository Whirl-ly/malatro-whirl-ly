package cl.uchile.dcc
package EF2
import suits.Suit
import ranks.Rank
import jokers.*
/**
 * Represents a card defined by its Range and Suit
 * @param _rank Range of the card
 * @param _suit Suit of the card
 */
class Card(private val _rank: Rank, private val _suit: Suit) {
 
  /**
   * Range getter method from a card
   *
   * @return Range type of the Card
   * @see [[ranks.Rank Range Type]]
   */
  def rank: Rank = _rank

  /**
   * Suit getter method from a card
   *
   * @return Suit type of the Card
   * @see [[suits.Suit Suit Type]]
   */
  def suit: Suit = _suit

  
  /**
   * Compares two cards through its attributes
   *
   * @param obj Object to compare
   * @return True if cards are the same / false if not
   */
  override def equals(obj:Any): Boolean =
    if obj.isInstanceOf[Card] then
      val other = obj.asInstanceOf[Card]
      this.rank == other.rank && this.suit == other.suit
    else
      false

  /**
   * Applies score depending on the interaction between a card and a list of jokers
   *
   * @note The first step consists of adding chips depending on the rank of the card.
   *       After that, each joker will interact with the card properties.
   * @param score predisposed score to update
   * @param Jokers list of jokers to interact with
   * @return updated score
   * @see [[EF2.ranks.Rank.applyScore() applyScore method for Range class]]
   * @see [[EF2.suits.Suit.applyScore() applyScore method for Suit class]]
   */
  def applyScore(score: Score, Jokers: List[Joker]): Score = {
    //add chips depending on the rank of the card
    score.chips_(score.chips + this.rank.value)
    //apply jokers effects on cards
    for (j <- Jokers) {
      this.rank.applyScore(score,j)
      this.suit.applyScore(score,j)
    }
    score
  }
  
}

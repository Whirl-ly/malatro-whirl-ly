package cl.uchile.dcc
package EF2.hand

import EF2.exceptions.{MaxDiscardCountException, MaxPlayCountException}
import EF2.hand.ListOps.*
import EF2.jokers.Joker
import EF2.Card
import EF2.combinations.*
import EF2.Score
/**
 * Represents a hand defined by a list of cards and jokers
 * @param _cards mutable list of cards
 * @param _jokers mutable list of jokers
 */
class Hand(private var _cards: List[Card], private var _jokers: List[Joker]) extends ResolveHand{

  /**
   * Internal counter for playing a hand
   * @note cannot be >3
   * @see [[play How play works]]
   */
  private var playCount: Int = 1
  /**
   * Internal counter for discarding a card
   * @note cannot be >3
   * @see [[discard How discard works]]
   */
  private var discardCount: Int = 1

  /**
   * cards getter method from a hand
   * @return hand of cards (list)
   */
  def cards: List[Card] = _cards

  /**
   * jokers getter method from a hand
   * @return hand of jokers (list)
   */
  def jokers: List[Joker] = _jokers

  /**
   * Adds a new card on a hand
   * @param newCard Card to add
   * @throws scala.IllegalArgumentException when adding more than 8 cards to a hand
   */
   def addCard(newCard: Card): Unit = {
    if (_cards.length >= 8) {
      throw new IllegalArgumentException("No se pueden tener más de 8 cartas a la mano")
    }
    _cards = addElem(cards, newCard)
  }

  /**
   * Removes a card inside a hand
   * @param i index of the card to remove
   */
  def removeCard(i: Int): Unit = {
    _cards = removeElem(cards, i)
  }

  /**
   * Internal method helper to remove a list of cards inside a hand
   * @param indexes location of the cards to remove
   * @note does it by sorting the indexes in descendent order (to prevent index conflict)
   * @see [[play How play works]]
   * @see [[discard How discard works]]
   */
  private def removeCards(indexes: List[Int]): Unit = {
    val orderedIndexes = indexes.sorted.reverse
    for (i <- orderedIndexes){
      removeCard(i)
    }
  }

  /**
   * Adds a new joker on a hand
   *
   * @param newJoker joker to add
   * @throws IllegalArgumentException when adding more than 2 jokers to a hand
   */
  def addJoker(newJoker: Joker): Unit = {
    if (_jokers.length >= 2) {
      throw new IllegalArgumentException("No se pueden tener más de 2 jokers a la mano")
    }
    _jokers = addElem(jokers, newJoker)
  }

  /**
   * Removes a joker from hand
   * @param i index of the joker to remove
   */
  def removeJoker(i: Int): Unit = {
    _jokers = removeElem(jokers, i)
  }

  /**
   * Discard certain cards from a hand
   *
   * @param indexes index list of the cards desired to discard
   * @return list of cards discarded
   * @throws MaxDiscardCountException when trying to discard more than 3 times
   */
  def discard(indexes: List[Int]): List[Card] = {

    // ---- validation process ----
    if (discardCount >= 3) {
      discardCount = 1
      throw new MaxDiscardCountException("No se puede descartar más de 3 veces un conjunto de cartas")
    }
    validate(indexes, _cards)

    // ---- discard process ----

    //first we map the cards played (list to return)
    val discardedCards = indexes.map(i => cards(i))
    //then, we remove the same cards in descendent order (to prevent index conflict)
    removeCards(indexes)
    discardCount+=1 // update discard counter
    discardedCards
  }

  /**
   * Plays a certain hand of cards
   *
   * @param indexes index list of the cards desired to play
   * @return final score (score.chips * score.multiplier)
   * @throws MaxPlayCountException when trying to play more than 3 times
   * @note The played cards are removed from the hand
   *
   */
  def play(indexes: List[Int]): Int = {

    //---- validation process ----
    if (playCount >= 3) {
      playCount = 1
      throw new MaxPlayCountException("No se puede jugar más de 3 veces un conjunto de cartas")
    }

    validate(indexes, _cards)
    //---- play process ----
    // first, we map the cards to play
    val playedCards = indexes.map(i => cards(i))
    //then we determine the best combination possible
    val cardCombination: Combination = determineCombination(playedCards)
    //initialize the value of the base score of the combination
    val score: Score = cardCombination.bScore
    //and we update the score based on the cards and jokers
    for (card <- playedCards){
      card.applyScore(score, jokers)
    }
    //to finally update the score based on the type of combination and jokers
    for (j <- jokers){
      cardCombination.applyScore(score,j)
    }

    //then, we remove the same cards in descendent order
    removeCards(indexes)
    playCount += 1 //update playcount
    //return final score
    score.chips*score.multiplier
  }
}

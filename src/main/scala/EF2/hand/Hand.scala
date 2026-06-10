package cl.uchile.dcc
package EF2.hand

import EF2.exceptions.{MaxDiscardCountException, MaxPlayCountException}
import EF2.hand.ListOps.*
import EF2.jokers.Joker
import EF2.Card
import EF2.hand.ValidateAction

/**
 * Represents a hand defined by a list of cards and jokers
 * @param _cards mutable list of cards
 * @param _jokers mutable list of jokers
 */
class Hand(private var _cards: List[Card], private var _jokers: List[Joker]) extends ValidateAction{

  /**
   * Internal counter for playing a hand
   *
   * @see play method on a hand
   */
  private var playCount: Int = 1
  /**
   * Internal counter for discarding a card
   *
   * @see discard method on a hand
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
   * Removes a list of cards inside a hand
   * @param indexes location of the cards to remove
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
   * @throws scala.IllegalArgumentException when adding more than 2 jokers to a hand
   */
  def addJoker(newJoker: Joker): Unit = {
    if (_jokers.length >= 2) {
      throw new IllegalArgumentException("No se pueden tener más de 2 jokers a la mano")
    }
    _jokers = addElem(jokers, newJoker)
  }

  def removeJoker(i: Int): Unit = {
    _jokers = removeElem(jokers, i)
  }
  def discard(indexes: List[Int]): List[Card] = {

    if (discardCount >= 3) {
      discardCount = 1
      throw new MaxDiscardCountException("No se puede descartar más de 3 veces un conjunto de cartas")
    }
    validate(indexes, _cards)



    //first we map the cards played (list to return)
    val discardedCards = indexes.map(i => cards(i))
    //then, we remove the same cards in descendent order (to prevent index conflict)
    removeCards(indexes)
    discardCount+=1
    print(discardCount)
    discardedCards
  }
  /**
   * Receives indexes of the cards desired to play contained in the hand
   *
   * The played cards are removed from the hand
   * @param indexes list of indexes
   * @return list of cards played
   */
  def play(indexes: List[Int]): List[Card] = {
    if (playCount >= 3) {
      playCount = 1
      throw new MaxPlayCountException("No se puede jugar más de 3 veces un conjunto de cartas")
    }

    validate(indexes, _cards)
    //same procedure as discard cards here
    val playedCards = indexes.map(i => cards(i))
    //then, we remove the same cards in descendent order (to prevent index conflict)
    removeCards(indexes)
    playCount += 1
    print(playCount)
    playedCards
    }
}

package cl.uchile.dcc
package EF3.hand

import EF3.Card

/**
 * Validates a certain action (playing/discarding) over cards inside a hand
 * @see [[Hand.play() How play works]]
 * @see [[Hand.discard() How discard works]]
 */
abstract class ValidateAction{
  /**
   * Validates if the action is valid by checking potential exception cases
   * @param indexes index list of the cards desired to act on
   * @param cards list of cards which are going to be actioned
   * @throws IllegalArgumentException if indexes is empty or its length is more than 5 units
   * @throws IndexOutOfBoundsException if indexes is invalid (pointer out of bounds)
   */
  protected def validate(indexes: List[Int], cards: List[Card]): Unit ={
    if (indexes.isEmpty) {
      throw new IllegalArgumentException("Can't discard/play less than 1 card")
    }

    if (indexes.length > 5) {
      throw new IllegalArgumentException("Can't discard/play more than 5 cards")

    }
    for (i <- indexes) {
      if (i < 0 || i >= cards.length) {
        throw new IndexOutOfBoundsException("Can't play/discard with an invalid index list")
      }
    }
  }

}

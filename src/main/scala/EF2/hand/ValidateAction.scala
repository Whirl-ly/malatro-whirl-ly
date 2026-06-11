package cl.uchile.dcc
package EF2.hand

import EF2.Card

/**
 * Validates a certain action (playing/discarding) over cards inside a hand
 * @see play and discard method on Hand class
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
      throw new IllegalArgumentException("No se puede descartar menos de 1 carta")
    }

    if (indexes.length > 5) {
      throw new IllegalArgumentException("No se puede descartar mas de 5 cartas")

    }
    for (i <- indexes) {
      if (i < 0 || i >= cards.length) {
        throw new IndexOutOfBoundsException("No se puede descartar una lista de índices inválidos")
      }
    }
  }

}

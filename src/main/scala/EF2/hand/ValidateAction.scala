package cl.uchile.dcc
package EF2.hand

import EF2.Card

abstract class ValidateAction{

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

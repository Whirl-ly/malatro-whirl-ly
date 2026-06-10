package cl.uchile.dcc
package EF2.jokers

/**
 * Representation of evenJoker (type of joker)
 */
class EvenJoker extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[EvenJoker]

  override def hashCode(): Int = getClass.hashCode()

}

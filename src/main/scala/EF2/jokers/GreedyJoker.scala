package cl.uchile.dcc
package EF2.jokers

/**
 * Representation of greedyJoker (type of joker) 
 */
class GreedyJoker extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[GreedyJoker]

  override def hashCode(): Int = getClass.hashCode()

}

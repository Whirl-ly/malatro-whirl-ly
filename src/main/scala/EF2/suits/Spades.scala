package cl.uchile.dcc
package EF2.suits

/**
 * Spades (type of suit) representation 
 */
class Spades extends applyForSuit{
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Spades]

  override def hashCode(): Int = getClass.hashCode()
}

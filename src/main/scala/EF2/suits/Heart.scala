package cl.uchile.dcc
package EF2.suits

/**
 * Heart (type of suit) representation
 */

class Heart extends applyForSuit {

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Heart]
  
  override def hashCode(): Int = getClass.hashCode()
}

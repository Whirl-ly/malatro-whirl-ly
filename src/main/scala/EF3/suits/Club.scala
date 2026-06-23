package cl.uchile.dcc
package EF3.suits


/**
 * Club (type of suit) representation
 */
class Club extends applyForSuit{

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Club]


}

package cl.uchile.dcc
package EF2.suits


/**
 * Diamond (type of suit) representation
 */
class Diamond extends applyForSuit{
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Diamond]

  override def hashCode(): Int = getClass.hashCode()
  
  override def applyScore(score: Score, )
}

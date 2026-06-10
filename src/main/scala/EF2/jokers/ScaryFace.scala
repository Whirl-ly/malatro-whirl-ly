package cl.uchile.dcc
package EF2.jokers

/**
 * Representation of scaryFace (type of joker)
 */
class ScaryFace extends JokerApply {
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[ScaryFace]

  override def hashCode(): Int = getClass.hashCode()

}

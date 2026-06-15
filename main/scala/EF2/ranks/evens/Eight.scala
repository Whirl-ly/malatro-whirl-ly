package cl.uchile.dcc
package EF2.ranks.evens

/**
 * Eight (type of rank) representation
 */
class Eight extends AllEven {
  /* getters */
  override def value: Int = 8
  override def order: Int = 8

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Eight]



}

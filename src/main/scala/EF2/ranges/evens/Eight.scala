package cl.uchile.dcc
package EF2.ranges.evens

class Eight extends AllEven {
  /* getters */
  override def value: Int = 8
  override def order: Int = 8

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Eight]
  override def hashCode(): Int = value * 31 + order

}

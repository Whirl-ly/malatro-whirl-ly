package cl.uchile.dcc
package EF2.ranges.evens


class Ten extends AllEven {
  /* getters */
  override def value: Int = 10
  override def order: Int = 10

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Ten]
  override def hashCode(): Int = value * 31 + order
}

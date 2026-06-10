package cl.uchile.dcc
package EF2.ranges.evens

class Four extends AllEven {
  /* getters */
  override def value: Int = 4
  override def order: Int = 4

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Four]
  
  override def hashCode(): Int = value * 31 + order

}

package cl.uchile.dcc
package EF2.ranges.evens


class Six extends AllEven {
  /* getters */
  override def value: Int = 6
  override def order: Int = 6

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Six]
    
  override def hashCode(): Int = value * 31 + order
  
}

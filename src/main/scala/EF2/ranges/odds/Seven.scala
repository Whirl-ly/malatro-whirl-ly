package cl.uchile.dcc
package EF2.ranges.odds

class Seven extends AllOdd {
  /* getters */
  override def value: Int = 7
  override def order: Int = 7

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Seven]
    
  override def hashCode(): Int = value * 31 + order

}

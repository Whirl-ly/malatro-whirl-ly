package cl.uchile.dcc
package EF2.ranges.odds

class Three extends AllOdd {
  /* getters */
  override def value: Int = 3
  override def order: Int = 3

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Three]
    
  override def hashCode(): Int = value * 31 + order
  
}

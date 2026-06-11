package cl.uchile.dcc
package EF2.ranks.odds

class Five extends AllOdd {
  /* getters */
  override def value: Int = 5
  override def order: Int = 5
  
  override def equals(obj:Any): Boolean =
    obj.isInstanceOf[Five]
  override def hashCode(): Int = value * 31 + order
  
}

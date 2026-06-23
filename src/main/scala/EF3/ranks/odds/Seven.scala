package cl.uchile.dcc
package EF3.ranks.odds

class Seven extends AllOdd {
  /* getters */
  override def value: Int = 7
  override def order: Int = 7

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Seven]



}

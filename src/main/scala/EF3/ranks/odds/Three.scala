package cl.uchile.dcc
package EF3.ranks.odds

class Three extends AllOdd {
  /* getters */
  override def value: Int = 3
  override def order: Int = 3

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Three]



}

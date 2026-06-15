package cl.uchile.dcc
package EF2.ranks.odds

class Nine extends AllOdd {
  /* getters */
  override def value: Int = 9
  override def order: Int = 9

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Nine]


}

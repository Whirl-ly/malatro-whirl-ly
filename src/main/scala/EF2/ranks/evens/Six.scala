package cl.uchile.dcc
package EF2.ranks.evens


class Six extends AllEven {
  /* getters */
  override def value: Int = 6
  override def order: Int = 6

  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Six]




}

package cl.uchile.dcc
package EF2.ranks.figures

class Queen extends AllFigure {
  /* getters */
  override def value: Int = 10
  override def order: Int = 12
  
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[Queen]
  override def hashCode(): Int = value * 31 + order

}

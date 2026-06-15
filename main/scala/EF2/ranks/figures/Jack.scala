package cl.uchile.dcc
package EF2.ranks.figures

class Jack extends AllFigure {
  /* getters */
  override def value: Int = 10
  override def order: Int = 11
  
  override def equals(obj:Any): Boolean =
    obj.isInstanceOf[Jack]

  override def hashCode(): Int = value * 31 + order


}

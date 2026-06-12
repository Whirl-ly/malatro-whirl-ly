package cl.uchile.dcc
package EF2.ranks.figures

class King extends AllFigure {
  /* getters */
  override def value: Int = 10
  override def order: Int = 13
  
  override def equals(obj: Any): Boolean =
    obj.isInstanceOf[King]


  override def hashCode(): Int = value * 31 + order

}

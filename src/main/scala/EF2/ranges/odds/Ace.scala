package cl.uchile.dcc
package EF2.ranges.odds


/**
 * Ace (type of range) representation
 * 
 * There are two types: low Ace (order = 1) or high Ace (order = 14)
 * @param _order specifies order inside deck (it can be 1 or 14)
 */
class Ace(private val _order: Int) extends AllOdd {
  require(_order ==1 || _order == 14, "The ace order has to be 1 or 14")
  /* getters */
  override def order: Int = _order
  override def value: Int = 11
  
  override def equals(obj:Any): Boolean =
    obj.isInstanceOf[Ace]
  
  override def hashCode(): Int = value * 31 + order
}

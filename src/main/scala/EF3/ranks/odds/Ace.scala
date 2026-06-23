package cl.uchile.dcc
package EF3.ranks.odds

/**
 * Ace (type of rank) representation
 * 
 * There are two types: low Ace (order = 1) or high Ace (order = 14)
 *
 * @see [[EF3.combinations.CombinationBase.isStraight() How a Straight Combination solves the dual nature of an Ace Rank]]
 */
class Ace extends AllOdd {
  /* getters */
  override def order: Int = 1 //by default
  override def value: Int = 11
  
  override def equals(obj:Any): Boolean =
    obj.isInstanceOf[Ace]



}

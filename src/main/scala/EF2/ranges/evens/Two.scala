package cl.uchile.dcc
package EF2.ranges.evens

class Two extends AllEven{
    /* getters */
    override def value: Int =  2
    override def order: Int = 2

    override def equals(obj: Any): Boolean =
        obj.isInstanceOf[Two]
    override def hashCode(): Int = value * 31 + order
}

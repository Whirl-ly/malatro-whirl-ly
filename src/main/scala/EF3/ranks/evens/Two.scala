package cl.uchile.dcc
package EF3.ranks.evens

class Two extends AllEven{
    /* getters */
    override def value: Int =  2
    override def order: Int = 2

    override def equals(obj: Any): Boolean =
        obj.isInstanceOf[Two]


}

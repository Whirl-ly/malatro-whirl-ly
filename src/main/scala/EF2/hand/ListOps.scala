package cl.uchile.dcc
package EF2.hand

/**
 * Contains functions used to append and remove elements 
 * without losing generality.
 */

object ListOps {
  
  /**
   * Appends element to list
   *
   * @param list   list of elements
   * @param element element to add
   * @tparam T type of element(s)
   * @return new list with element added
   */
  def addElem[T](list: List[T], element: T): List[T] = {
    list :+ element
  }

  /**
   * Removes element from list
   *
   * @param list  list of elements
   * @param index index of element to remove
   * @tparam T type of element(s)
   * @return new list with element removed
   */
  def removeElem[T](list: List[T], index: Int): List[T] = {
    if (index < 0 || index >= list.length) {
      throw new IndexOutOfBoundsException("No se puede quitar un element que no exista en la mano")
    }
    list.take(index) ++ list.drop(index + 1)
  }


}

package cl.uchile.dcc
package EF3.hand

/**
 * Contains general functions used to append and remove elements from Hand.
 */

object ListOps {
  
  /**
   * Appends element (Card/Joker) to list
   *
   * @param list   List of elements
   * @param element Element to add
   * @tparam T Type of element(s) (Card/Joker)
   * @return New list with element added
   * @see [[Hand.addCard() How addCard works]]
   * @see [[Hand.addJoker() How addJoker works]]
   */
  def addElem[T](list: List[T], element: T): List[T] = {
    list :+ element
  }

  /**
   * Removes element (Card/Joker) from list
   *
   * @param list  List of elements
   * @param index Index of element to remove
   * @tparam T Type of element(s) (Card/Joker)
   * @return New list with element removed
   * @throws IndexOutOfBoundsException When trying to remove a non-existent element from list
   * @see [[Hand.removeCard() How removeCard works]]
   * @see [[Hand.removeJoker() How removeJoker works]]
   */
  def removeElem[T](list: List[T], index: Int): List[T] = {
    if (index < 0 || index >= list.length) {
      throw new IndexOutOfBoundsException("Can't remove a non-existent element from Hand")
    }
    list.take(index) ++ list.drop(index + 1)
  }


}

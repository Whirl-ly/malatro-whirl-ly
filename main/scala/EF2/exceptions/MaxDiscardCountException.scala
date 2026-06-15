package cl.uchile.dcc
package EF2.exceptions

/**
 * Exception that interrupts the flow when we surpass the Discard Counter
 * when discarding a hand of cards
 * @see [[EF2.hand.Hand.discard() How discard Works]]
 * @param message message to print
 */
class MaxDiscardCountException(message: String) extends Exception(message)


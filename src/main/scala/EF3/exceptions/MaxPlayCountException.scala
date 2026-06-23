package cl.uchile.dcc
package EF3.exceptions
/**
 * Exception that interrupts the flow when we surpass the Play Counter
 * when playing a hand of cards
 *
 * @see [[EF3.hand.Hand.play() How play works]]
 * @param message message to print
 */
class MaxPlayCountException(message: String) extends Exception(message)


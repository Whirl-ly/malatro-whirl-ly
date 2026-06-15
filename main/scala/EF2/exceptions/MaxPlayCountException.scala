package cl.uchile.dcc
package EF2.exceptions
/**
 * Exception that interrupts the flow when we surpass the Play Counter
 * when playing a hand of cards
 * @see [[EF2.hand.Hand.play() How play works]]
 * @param message message to print
 */
class MaxPlayCountException(message: String) extends Exception(message)


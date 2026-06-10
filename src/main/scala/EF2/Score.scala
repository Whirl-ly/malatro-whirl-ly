package cl.uchile.dcc
package EF2

/**
 * Represents a total score composed by its chips and multiplicador
 * @param _chips base value of the score
 * @param _multiplier value to multiply chips
 */
class Score(private var _chips: Int, private var _multiplier: Int){

  /* getters */
  def chips: Int = _chips
  def multiplier: Int = _multiplier

  /* setters */
  def chips_(newChips: Int): Unit = _chips = newChips
  def multiplier_(newMult: Int):Unit =_multiplier = newMult


}

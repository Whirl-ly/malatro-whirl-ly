package cl.uchile.dcc
package EF2

/**
 * Represents a total score composed by its chips and multiplicador
 * @param _chips base value of the score
 * @param _multiplier value to multiply chips
 */
class Score(private var _chips: Int, private var _multiplier: Int){
  
  /**
   * Chips getter method from a Score
   * @return Chips component of a score 
   */
  def chips: Int = _chips

  /**
   * Multiplier getter method from a Score
   * @return Multiplier component of a score 
   */
  def multiplier: Int = _multiplier
  
  /**
   * Chips setter method from a Score:
   * overwrites the Chips component with new value
   * @param newChips new chips value 
   */
  def chips_(newChips: Int): Unit = _chips = newChips

  /**
   * Multiplier setter method from a Score:
   * overwrites the Multiplier with new value
   * @param newMult new multiplier value
   */
  def multiplier_(newMult: Int):Unit =_multiplier = newMult


}

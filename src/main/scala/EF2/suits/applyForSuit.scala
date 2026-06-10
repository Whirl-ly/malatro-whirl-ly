package cl.uchile.dcc
package EF2.suits
import EF2.Score
import EF2.jokers.*

abstract class applyForSuit extends Suit{
  
  def applyScore(score: Score, j: Joker): Score = {
    score
  }

}

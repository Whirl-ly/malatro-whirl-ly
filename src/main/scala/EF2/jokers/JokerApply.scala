package cl.uchile.dcc
package EF2.jokers
import EF2.ranges.*
import EF2.Score
import EF2.suits.*
import EF2.combinations.*
import EF2.Card
abstract class JokerApply extends Joker {
  //Default behavior: returns the same score (for now)
  def applyRange(cRange: Range, score: Score): Score = {
    score
  }
  def applySuit(cSuit: Suit, score: Score): Score = {
    score
  }
  def applyCombination(cCombination: Combination, score: Score): Score = {
    score
  }
  def applyCard(card: Card, score: Score): Score = {
    //I assume that the total score of a card based on the joker is 
    //the sum of the scores set by applyRange and applySuit components
    val score1: Score = applyRange(card.range, score)
    val score2: Score = applySuit(card.suit, score)
    score.chips_(score1.chips + score2.chips)
    score.multiplier_(score1.multiplier + score2.multiplier)
    score
  }
}

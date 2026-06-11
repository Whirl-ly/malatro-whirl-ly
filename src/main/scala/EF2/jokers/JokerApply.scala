package cl.uchile.dcc
package EF2.jokers
import EF2.ranks.*
import EF2.Score
import EF2.suits.*
import EF2.combinations.*
abstract class JokerApply extends Joker {
  //Default behavior: returns the same score 
  def applyRange(cRank: Rank, score: Score): Score = {
    score
  }
  def applySuit(cSuit: Suit, score: Score): Score = {
    score
  }
  def applyCombination(cCombination: Combination, score: Score): Score = {
    score
  }
}

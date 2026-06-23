package cl.uchile.dcc
package EF3.jokers
import EF3.Score

/**
 * Abstract class that defines the default interaction behavior between
 * Jokers and properties of a Card/Hand of cards
 * @note Default interaction behavior for all methods: 
 *       
 *       return the same score
 */
abstract class JokerApply extends Joker {
  //Default behavior: returns the same score
  def applyEvenRank(score: Score): Score = {
    score
  }

  def applyOddRank(score: Score): Score = {
    score
  }

  def applyFigureRank(score: Score): Score = {
    score
  }

  def applyDiamond(score: Score): Score = {
    score
  }

  def applyOtherSuit(score: Score): Score = {
    score
  }

  def applyStraight(score: Score): Score = {
    score
  }

  def applyOtherCombination(score: Score): Score = {
    score
  }
}

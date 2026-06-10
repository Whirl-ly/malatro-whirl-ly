package cl.uchile.dcc
package EF2.ranges.evens
import EF2.ranges.ApplyForRange
import EF2.Score

abstract class AllEven extends ApplyForRange {
  override def clasification: Object = Even

  override def applyEvenJoker(score: Score): Unit = {
    score.multiplier_(score.multiplier + 4)
  }
}

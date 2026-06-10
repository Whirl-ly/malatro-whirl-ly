package cl.uchile.dcc
package EF2.ranges.figures

import EF2.ranges.ApplyForRange
import EF2.Score
abstract class AllFigure extends ApplyForRange {
  override def clasification: Object = Figure
  
  override def applyScaryFace(score: Score): Unit = {
    score.chips_(score.chips + 30)
  }
}

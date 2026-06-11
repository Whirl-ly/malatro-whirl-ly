package cl.uchile.dcc
package EF2.ranks.figures

import EF2.ranks.ApplyForRank
import EF2.Score
abstract class AllFigure extends ApplyForRank {
  override def classification: Object = Figure
  
  override def applyScaryFace(score: Score): Unit = {
    score.chips_(score.chips + 30)
  }
}

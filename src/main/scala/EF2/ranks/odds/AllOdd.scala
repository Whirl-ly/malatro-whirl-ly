package cl.uchile.dcc
package EF2.ranks.odds

import EF2.ranks.ApplyForRank

abstract class AllOdd extends ApplyForRank {
  override def classification: Object = Odd
}

package cl.uchile.dcc
import munit.FunSuite
import EF3.ranks.evens.*
import EF3.ranks.figures.*
import EF3.ranks.odds.*
import EF3.ranks.*
import EF3.Score
import EF3.jokers.*

class RankTest extends FunSuite {
  var GreedyJ: Joker = _
  var DeviousJ: Joker = _
  var ScaryF: Joker = _
  var EvenJ: Joker = _
  var Score: Score = _
  var Two: Rank = _
  var Five: Rank = _
  var Six: Rank = _
  var Seven: Rank = _
  var Jack: Rank = _
  var Queen: Rank = _
  var CoolerJack: Rank = _

  override def beforeEach(context: BeforeEach): Unit = {
    GreedyJ = new GreedyJoker
    DeviousJ = new DeviousJoker
    ScaryF = new ScaryFace
    EvenJ = new EvenJoker
    Score = new Score(0,0)
    Two = new Two
    Five = new Five
    Six = new Six
    Seven = new Seven
    Jack = new Jack
    Queen = new Queen
    CoolerJack = new Jack
  }

  test("Use of getters"):
    assertEquals(Five.classification, Odd)
    assertEquals(Five.value, 5)
    assertEquals(Five.order, 5)
    assertEquals(Six.classification, Even)
    assertEquals(Six.value, 6)
    assertEquals(Six.order, 6)
    assertEquals(Jack.classification, Figure)
    assertEquals(Jack.value, 10)
    assertEquals(Jack.order, 11)

  test("comparison of objects (equals method) with same properties except order"):
    assertEquals(Jack.classification, Queen.classification)
    assertEquals(Jack.value, Queen.value)
    assert(Jack.order != Queen.order)
    assert(Jack != Queen)


  test("comparison of same objects (in all ways) but different variable name"):
    assertEquals(Jack, CoolerJack)

  test("Using applyScore for Even Ranks with Even Joker"):
    Six.applyScore(Score, EvenJ)
    assertEquals(Score.multiplier, 4)

  test("Checking if the effect of Even Ranks with Even Joker accumulates"):
    Six.applyScore(Score, EvenJ)
    Two.applyScore(Score, EvenJ)
    assertEquals(Score.multiplier, 8)

  test("Using applyScore for Even Ranks with rest of Joker types (mustn't have effect on score multiplier)"):
    Six.applyScore(Score, ScaryF)
    Six.applyScore(Score, GreedyJ)
    Six.applyScore(Score, DeviousJ)
    assertEquals(Score.multiplier, 0)
    assertEquals(Score.chips, 0)

  test("Using applyScore for other type of Ranks with Even Joker (mustn't have effect on score multiplier)"):
    Seven.applyScore(Score, EvenJ)
    Queen.applyScore(Score, EvenJ)
    assertEquals(Score.multiplier, 0)


}
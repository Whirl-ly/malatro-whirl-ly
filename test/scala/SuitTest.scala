package cl.uchile.dcc
import munit.FunSuite
import EF2.suits.*
import EF2.Score
import EF2.jokers.*

class SuitTest extends FunSuite{
  var GreedyJ: Joker = _
  var DeviousJ: Joker = _
  var ScaryF: Joker = _
  var EvenJ: Joker = _
  var Score: Score = _
  var Diamond: Suit = _
  var SuperMegaIncredibleDiamondEX: Suit = _
  var Club: Suit = _
  var Heart: Suit = _
  var Spades: Suit = _

  override def beforeEach(context: BeforeEach): Unit = {
    GreedyJ = new GreedyJoker
    DeviousJ = new DeviousJoker
    ScaryF = new ScaryFace
    EvenJ = new EvenJoker
    Score = new Score(0, 0)
    Diamond = new Diamond
    SuperMegaIncredibleDiamondEX = new Diamond
    Club = new Club
    Heart = new Heart
    Spades = new Spades
  }

  test("comparison test (equals method)"):
    //different variable name, same type
    assertEquals(Diamond, SuperMegaIncredibleDiamondEX)
    assert(Diamond != Heart)

  test("Using applyScore for Diamond Suit with GreedyJoker"):
    Diamond.applyScore(Score, GreedyJ)
    assertEquals(Score.multiplier, 3)

  test("Using applyScore for other Suits with GreedyJoker (mustn't have any effect on score multiplier)"):
    Heart.applyScore(Score, GreedyJ)
    Club.applyScore(Score,  GreedyJ)
    Spades.applyScore(Score,GreedyJ)
    assertEquals(Score.multiplier, 0)

  test("Using applyScore for Diamond Suit with other Jokers (mustn't have any effect on score multiplier)"):
    Diamond.applyScore(Score, EvenJ)
    Diamond.applyScore(Score, DeviousJ)
    Diamond.applyScore(Score, ScaryF)
    assertEquals(Score.multiplier,0)


  test("Checking if a GreedyJoker effect accumulates with more than one Diamond Card"):
    Diamond.applyScore(Score, GreedyJ)
    SuperMegaIncredibleDiamondEX.applyScore(Score, GreedyJ)
    assertEquals(Score.multiplier, 6)
}


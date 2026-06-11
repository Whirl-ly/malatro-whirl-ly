package cl.uchile.dcc
import munit.FunSuite
import EF2.suits.*
import EF2.*
import EF2.jokers.*
import EF2.ranks.evens.Two
import EF2.ranks.figures.{Jack, King}
import EF2.ranks.odds.{Ace, Three}



class cardTest extends FunSuite:

  var score2: Score = _
  var score1: Score = _
  var LowAceS: Card = _
  var HighAceS: Card = _
  var ThreeH: Card = _
  var TwoC: Card = _
  var KingD: Card = _
  var JackH: Card = _
  var DeviousJ: DeviousJoker = _
  var EvenJ: EvenJoker = _
  var ScaryF: ScaryFace = _
  var GreedyJ: GreedyJoker = _

  override def beforeEach(context: BeforeEach): Unit = {
    score1 = new Score(1000, 3)
    score2 = new Score(300,10)
    LowAceS = new Card(new Ace(1), new Spades)
    HighAceS = new Card(new Ace(14), new Spades)
    ThreeH = new Card(new Three, new Heart)
    TwoC = new Card(new Two, new Club)
    KingD = new Card(new King, new Diamond)
    JackH = new Card(new Jack, new Heart)
    DeviousJ = new DeviousJoker
    EvenJ = new EvenJoker
    ScaryF = new ScaryFace
    GreedyJ = new GreedyJoker
  }
  test("different jokers type test"):
    assert(EvenJ != DeviousJ)

  test("construction of scores with zero values test"):
    val zeroScore = new Score(0,0)
    assert(zeroScore.chips == 0)
    assert(zeroScore.multiplier == 0)
    
  test("construction of score test"):
    assert(score1.chips == 1000)
    assert(score1.multiplier == 3)

  test("modification of scores test (using setters)"):
    score1.chips_(100)
    assertEquals(score1.chips, 100)
    score1.multiplier_(5)
    assertEquals(score1.multiplier, 5)

  test("comparing scores test"):
    assert(score1.chips != score2.chips)
    assert(score1.multiplier != score2.multiplier)
    assert(score1.multiplier < score2.multiplier)

  test("construction and comparing cards test"):
    assert(LowAceS.rank.value == 11)
    assert(LowAceS.rank.order == 1)
    assert(LowAceS.rank.classification == ThreeH.rank.classification)
    assert(KingD.rank.classification == JackH.rank.classification)
    assert(HighAceS.rank.order == 14)
  test("cards with same suit and different value test"):
    assert(ThreeH.suit == JackH.suit)
    assert(ThreeH.rank.value != JackH.rank.value)


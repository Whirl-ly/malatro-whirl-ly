package cl.uchile.dcc
import munit.FunSuite
import EF2.suits.*
import EF2.*
import EF2.combinations.*
import EF2.ranks.evens.{Four, Ten, Two}
import EF2.ranks.figures.{Jack, King, Queen}
import EF2.ranks.odds.{Ace, Five, Three}
import EF2.combinations.straights.{Straight, StraightFlush}
import EF2.hand.*

class combinationsTest extends FunSuite {

  var LowAceS: Card = _
  var TwoS: Card = _
  var ThreeS: Card = _
  var FourS: Card = _
  var FiveS: Card = _
  var TwoH: Card = _
  var TwoC: Card = _
  var ThreeC: Card = _
  var FourD: Card = _
  var cincoC: Card = _
  var JackS: Card = _
  var TenH: Card = _
  var QueenC: Card = _
  var KingD: Card = _
  var HighAceS: Card = _

  override def beforeEach(context: BeforeEach): Unit = {
    LowAceS = new Card(new Ace(1), new Spades)
    TwoS = new Card(new Two, new Spades)
    ThreeS = new Card(new Three, new Spades)
    FourS = new Card(new Four, new Spades)
    FiveS = new Card(new Five, new Spades)
    TwoH = new Card(new Two, new Heart)
    ThreeC = new Card(new Three, new Club)
    FourD = new Card(new Four, new Diamond)
    cincoC = new Card(new Five, new Heart)
    TwoC = new Card(new Two, new Club)
    JackS = new Card(new Jack, new Spades)
    TenH = new Card(new Ten, new Heart)
    QueenC = new Card(new Queen, new Club)
    KingD = new Card(new King, new Diamond)
    HighAceS = new Card(new Ace(14), new Spades)
  }

  test("basic validation of a straightFlush - lowAce in straight tests"):
    val straightFlushCards = List(LowAceS, TwoS, ThreeS, FourS, FiveS)
    val straight = new StraightFlush
    assert(straight.validate(straightFlushCards))
    assertEquals(straight.bScore.chips, 100)
    assertEquals(straight.bScore.multiplier, 8)

  test("basic validation of a colorFlush combination"):
    val colorCards = List(ThreeS, FiveS, LowAceS, JackS, TwoS)
    val color = new ColorFlush
    assert(color.validate(colorCards))
    assertEquals(color.bScore.chips, 35)
    assertEquals(color.bScore.multiplier, 4)


  test("basic validation of a Straight combination"):
    val straightCards = List(LowAceS, TwoH, ThreeC, FourD, cincoC)
    val straight = new Straight
    assert(straight.validate(straightCards))
    assertEquals(straight.bScore.chips, 30)
    assertEquals(straight.bScore.multiplier, 4)

  test("basic validation of a Trio combination"):
    val trioCards = List(TwoC, TwoH, TwoS)
    val tri = new Trio
    assert(tri.validate(trioCards))
    assertEquals(tri.bScore.chips, 30)
    assertEquals(tri.bScore.multiplier, 3)

  test("basic validation of a de Pair combination"):
    val pairCards = List(TwoC, TwoH)
    val pair = new Pair
    assert(pair.validate(pairCards))
    assertEquals(pair.bScore.chips, 10)
    assertEquals(pair.bScore.multiplier, 2)

  test("basic validation of a HighCard combination"):
    val highCards = List(TwoC, FiveS, ThreeC, FourD, JackS)
    val high_card = new HighCard
    assert(high_card.validate(highCards))
    assertEquals(high_card.bScore.chips, 5)
    assertEquals(high_card.bScore.multiplier, 1)

  test("conflict test 1 - StraightFlush over ColorFlush and Straight"):
    val conflictiveCards = List(LowAceS, TwoS, ThreeS, FourS, FiveS)
    val toResolve = new Hand(conflictiveCards, List())
    val combination = toResolve.determineCombination(conflictiveCards)
    assertEquals(combination.bScore.chips, 100)
    assertEquals(combination.bScore.multiplier, 8)

  test("conflict test 2 - Trio over Pair"):
    val conflictiveCards2 = List(TwoC,TwoH,TwoS)
    val toResolve2 = new Hand(conflictiveCards2, List())
    val combination2 = toResolve2.determineCombination(conflictiveCards2)
    assertEquals(combination2.bScore.chips, 30)
    assertEquals(combination2.bScore.multiplier, 3)

  test("Straight with HighAce test"):
    val highStraight = List(TenH, JackS, QueenC, KingD, HighAceS)
    val straight = new Straight

    assert(straight.validate(highStraight))
    assertEquals(straight.bScore.chips, 30)
    assertEquals(straight.bScore.multiplier, 4)
}

package cl.uchile.dcc
import munit.FunSuite
import EF2.suits.*
import EF2.*
import EF2.combinations.*
import EF2.ranges.evens.{Four, Ten, Two}
import EF2.ranges.figures.{Jack, King, Queen}
import EF2.ranges.odds.{Ace, Five, Three}

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

  test("validacion basica de escalera de color - as bajo en escalera"):

    val straightflushCards = List(LowAceS, TwoS, ThreeS, FourS, FiveS)

    val straight = new StraightFlush
    assert(straight.validate(straightflushCards))
    assertEquals(straight.pBase.chips, 100)
    assertEquals(straight.pBase.multiplier, 8)



  test("validacion basica de color(flush)"):

    val colorCards = List(ThreeS, FiveS, LowAceS, JackS, TwoS)

    val color = new ColorFlush
    assert(color.validate(colorCards))
    assertEquals(color.pBase.chips, 35)
    assertEquals(color.pBase.multiplier, 4)


  test("validacion básica de Escalera"):
    val straightCards = List(LowAceS, TwoH, ThreeC, FourD, cincoC)

    val straight = new Straight

    assert(straight.validate(straightCards))
    assertEquals(straight.pBase.chips, 30)
    assertEquals(straight.pBase.multiplier, 4)

  test("validacion básica de Trío"):
    val trioCards = List(TwoC, TwoH, TwoS)

    val tri = new Trio

    assert(tri.validate(trioCards))
    assertEquals(tri.pBase.chips, 30)
    assertEquals(tri.pBase.multiplier, 3)

  test("validacion básica de Par"):
    val pairCards = List(TwoC, TwoH)

    val pair = new Pair

    assert(pair.validate(pairCards))
    assertEquals(pair.pBase.chips, 10)
    assertEquals(pair.pBase.multiplier, 2)

  test("validacion básica de Carta Alta"):
    val highCards = List(TwoC, FiveS, ThreeC, FourD, JackS)

    val high_card = new HighCard

    assert(high_card.validate(highCards))
    assertEquals(high_card.pBase.chips, 5)
    assertEquals(high_card.pBase.multiplier, 1)

  test("testeo de conflictos 1 - escala de color sobre color(flush) y escala normal"):
    val conflictiveCards = List(LowAceS, TwoS, ThreeS, FourS, FiveS)
    val resolve = new ResolveHand()
    val combination = resolve.determineCombination(conflictiveCards)

    assertEquals(combination.pBase.chips, 100)
    assertEquals(combination.pBase.multiplier, 8)

  test("testeo de conflictos 2 - trio sobre par"):
    val conflictiveCards2 = List(TwoC,TwoH,TwoS)
    val resolve2 = new ResolveHand()
    val combination2 = resolve2.determineCombination(conflictiveCards2)

    assertEquals(combination2.pBase.chips, 30)
    assertEquals(combination2.pBase.multiplier, 3)

  test("test escalera con as alto"):
    val highStraight = List(TenH, JackS, QueenC, KingD, HighAceS)
    val straight = new Straight

    assert(straight.validate(highStraight))
    assertEquals(straight.pBase.chips, 30)
    assertEquals(straight.pBase.multiplier, 4)
}

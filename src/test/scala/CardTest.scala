package cl.uchile.dcc
import munit.FunSuite
import EF3.suits.*
import EF3.*
import EF3.ranks.evens.*
import EF3.ranks.figures.*
import EF3.ranks.odds.*



class CardTest extends FunSuite:
  var AceH: Card = _
  var ThreeH: Card = _
  var TwoC: Card = _
  var KingD: Card = _
  var JackH: Card = _
  var CoolerJackH: Card = _

  override def beforeEach(context: BeforeEach): Unit = {
    AceH = new Card(new Ace, new Heart)
    ThreeH = new Card(new Three, new Heart)
    TwoC = new Card(new Two, new Club)
    KingD = new Card(new King, new Diamond)
    JackH = new Card(new Jack, new Heart)
    CoolerJackH = new Card(new Jack, new Heart)
  }

  test("use of getters for rank properties test"):
    assertEquals(AceH.rank.order, 1)
    assertEquals(AceH.rank.classification, Odd)
    assertEquals(AceH.rank.value, 11)
    assertEquals(ThreeH.rank.value, 3)
    assertEquals(ThreeH.rank.order, 3)
    assertEquals(ThreeH.rank.classification, Odd)

  test("cards with same suit and different value/order/classification test"):
    assertEquals(ThreeH.suit, JackH.suit)
    assert(ThreeH != JackH)

  test("testing card equality (equals method)"):
    //same card, different variable name
    assertEquals(JackH, CoolerJackH)
    //completely different cards
    assert(JackH != TwoC)


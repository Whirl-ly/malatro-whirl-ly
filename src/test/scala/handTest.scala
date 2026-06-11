package cl.uchile.dcc
import munit.FunSuite
import EF2.suits.*
import EF2.*
import EF2.jokers.*
import EF2.exceptions.*
import EF2.ranks.evens.*
import EF2.ranks.figures.{Jack, King, Queen}
import EF2.ranks.odds.*
import EF2.hand.Hand


class handTest extends FunSuite:
  var TwoD: Card = _
  var ThreeD: Card = _
  var FourD: Card = _
  var FiveD: Card = _
  var SixD: Card = _
  var JackC: Card = _
  var QueenS: Card = _
  var LowAceH: Card = _
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
  var Cards: List[Card] = _
  var Jokers: List[Joker] = _
  var Hand: Hand = _

  override def beforeEach(context: BeforeEach): Unit = {
    TwoD = new Card(new Two, new Diamond)
    ThreeD = new Card(new Three, new Diamond)
    FourD = new Card(new Four, new Diamond)
    FiveD = new Card(new Five, new Diamond)
    SixD = new Card(new Six, new Diamond)
    JackC = new Card(new Jack, new Club)
    QueenS = new Card(new Queen, new Spades)
    LowAceH =  new Card(new Ace(1), new Heart)
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
    Cards = List[Card]()
    Jokers = List[Joker]()
    Hand = new Hand(Cards, Jokers)
  }
  // ---- Construction section ----
  test("empty hand test"):
    assert(Hand.cards.isEmpty)
    assert(Hand.jokers.isEmpty)

  // ---- Adding section ----
  test("adding a card to hand test"):
    Hand.addCard(LowAceS)
    assertEquals(Hand.cards.head, LowAceS)

  test("adding a joker to hand test"):
    Hand.addJoker(DeviousJ)
    assertEquals(Hand.jokers.head, DeviousJ)

  test("cant have more than 8 cards"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(HighAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(KingD)
    intercept[IllegalArgumentException]:
      Hand.addCard(TwoC)

  test("cant have more than two jokers"):
    Hand.addJoker(EvenJ)
    Hand.addJoker(DeviousJ)
    intercept[IllegalArgumentException]:
      Hand.addJoker(GreedyJ)

  // ---- Removing Section ----
  test("removing a card from hand test"):
    Hand.addCard(KingD)
    Hand.addCard(ThreeH)
    Hand.removeCard(0)
    assertEquals(Hand.cards.head, ThreeH)

  test("removing a joker from hand test"):
    Hand.addJoker(DeviousJ)
    Hand.addJoker(EvenJ)
    Hand.removeJoker(1)
    assertEquals(Hand.jokers.head, DeviousJ)

  test("cannot remove a non existent card"):
    intercept[IndexOutOfBoundsException]:
      Hand.removeCard(0)

  test("cannot remove a non existent joker"):
    intercept[IndexOutOfBoundsException]:
      Hand.removeJoker(0)

  // ---- Playing section ----
  test("playing a generic hand test"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addJoker(EvenJ)
    val final_score = Hand.play(List(0,3,1))
    //two cards left in the hand
    assertEquals(Hand.cards, List[Card](TwoC, JackH))
    //expected result of final score:
    // combination of the hand played: HighCard - chips: 5, mult: 1
    // EvenJ + LowAceS - chips: +11, mult: 1
    // EvenJ + ThreeH - chips: +3, mult: 1
    // EvenJ + KingD - chips: +10, mult: 1
    // total: 29*1 = 29
    assertEquals(final_score, 29)

  test("example from statement - play application of a hand over final score"):
    Hand.addJoker(GreedyJ)
    Hand.addJoker(DeviousJ)
    Hand.addCard(TwoD)
    Hand.addCard(ThreeD)
    Hand.addCard(FourD)
    Hand.addCard(FiveD)
    Hand.addCard(SixD)
    Hand.addCard(JackC)
    Hand.addCard(QueenS)
    Hand.addCard(LowAceH)
    val final_score = Hand.play(List(0, 1, 2, 3, 4))
    assertEquals(final_score, 5060)

  test("MaxPlayCountException test (cannot play more than three times)"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(HighAceS)
    Hand.addCard(KingD)
    Hand.addCard(ThreeH)
    Hand.play(List(0, 3, 1))
    Hand.play(List(0, 2, 1))
    intercept[MaxPlayCountException]:
      Hand.play(List(0, 1, 2))

  test("cannot play more than 5 cards"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(HighAceS)
    intercept[IllegalArgumentException]:
      Hand.play(List(0, 1, 2, 3, 4, 5))

  test("cannot play an invalid index list"):
    Hand.addCard(LowAceS)
    intercept[IndexOutOfBoundsException]:
      Hand.play(List(8, -1, 7))

  test("cannot play less than 1 card"):
    Hand.addCard(HighAceS)
    intercept[IllegalArgumentException]:
      Hand.play(List())

  // ---- Discarding section ----
  test("cant discard more than 5 cards"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(HighAceS)
    intercept[IllegalArgumentException]:
      Hand.discard(List(0, 1, 2, 3, 4, 5))

  test("cant discard less than 1 card"):
    Hand.addCard(JackH)
    intercept[IllegalArgumentException]:
      Hand.discard(List())

  test("cant discard an invalid index list"):
    Hand.addCard(KingD)
    intercept[IndexOutOfBoundsException]:
      Hand.discard(List(8, -1, 7))

  test("MaxDiscardCountException test (cannot play more than three times)"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(HighAceS)
    Hand.addCard(KingD)
    Hand.addCard(ThreeH)
    Hand.discard(List(0, 1, 2))
    Hand.discard(List(0, 1, 2))
    intercept[MaxDiscardCountException]:
      Hand.discard(List(0, 1, 2))


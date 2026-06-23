package cl.uchile.dcc
import munit.FunSuite
import EF3.suits.*
import EF3.*
import EF3.jokers.*
import EF3.exceptions.*
import EF3.ranks.evens.*
import EF3.ranks.figures.{Jack, King, Queen}
import EF3.ranks.odds.*
import EF3.hand.Hand


class HandTest extends FunSuite:
  var TwoS: Card = _
  var ThreeS: Card = _
  var FourS: Card = _
  var FiveS: Card = _
  var TwoD: Card = _
  var ThreeD: Card = _
  var FourD: Card = _
  var FiveD: Card = _
  var SixD: Card = _
  var JackC: Card = _
  var QueenS: Card = _
  var AceH: Card = _
  var AceS: Card = _
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
    TwoS  = new Card(new Two, new Spades)
    ThreeS = new Card(new Three, new Spades)
    FourS = new Card(new Four, new Spades)
    FiveS = new Card(new Five, new Spades)
    TwoD = new Card(new Two, new Diamond)
    ThreeD = new Card(new Three, new Diamond)
    FourD = new Card(new Four, new Diamond)
    FiveD = new Card(new Five, new Diamond)
    SixD = new Card(new Six, new Diamond)
    JackC = new Card(new Jack, new Club)
    QueenS = new Card(new Queen, new Spades)
    AceH =  new Card(new Ace, new Heart)
    AceS = new Card(new Ace, new Spades)
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
    Hand.addCard(AceS)
    assertEquals(Hand.cards.head, AceS)

  test("adding a joker to hand test"):
    Hand.addJoker(DeviousJ)
    assertEquals(Hand.jokers.head, DeviousJ)

  test("cant have more than 8 cards"):
    Hand.addCard(AceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(AceH)
    Hand.addCard(ThreeH)
    Hand.addCard(KingD)
    val exception = intercept[IllegalArgumentException]:
      Hand.addCard(TwoC)
    //validating correct message
    assertEquals(exception.getMessage, "Can't have more than 8 cards in hand")

  test("cant have more than two jokers in hand"):
    Hand.addJoker(EvenJ)
    Hand.addJoker(DeviousJ)
    val exception = intercept[IllegalArgumentException]:
      Hand.addJoker(GreedyJ)
    assertEquals(exception.getMessage, "Can't have more than 2 jokers to hand")

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
    val exception = intercept[IndexOutOfBoundsException]:
      Hand.removeCard(0)
    assertEquals(exception.getMessage, "Can't remove a non-existent element from Hand")


  test("cannot remove a non existent joker"):
    val exception = intercept[IndexOutOfBoundsException]:
      Hand.removeJoker(0)
    assertEquals(exception.getMessage, "Can't remove a non-existent element from Hand")

  // ---- Playing section ----

  test("Playing hand of cards with empty Jokers list"):
    Hand.addCard(AceS) // +11 chips
    //base score of the combination: (5,1) (HighCard Combination)
    //expected result of the final score: 16*1
    assertEquals(Hand.play(List(0)),16)

  test("playing a generic hand test (one joker)"):
    Hand.addCard(AceS)
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
    // EvenJ + AceS - chips: +11, mult: 1
    // EvenJ + ThreeH - chips: +3, mult: 1
    // EvenJ + KingD - chips: +10, mult: 1
    // total: 29*1 = 29
    assertEquals(final_score, 29)

  test("playing a conflictive hand of cards test with: DeviousJ and EvenJ "):
    Hand.addJoker(DeviousJ)
    Hand.addJoker(EvenJ)

    //First round
    //Straight flush over ColorFlush, Straight and Pair
    //base score of the combination: (100,8)
    // Effect of DeviousJ (+100 chips): (200,8)
    Hand.addCard(AceS) // +11 chips:  (211,8)
    Hand.addCard(TwoS) // +2 chips + 4 mult (EvenJ) : (213,12)
    Hand.addCard(ThreeS) // +3 chips: (216,12)
    Hand.addCard(FourS) // +4 chips + 4 mult: (220, 16)
    Hand.addCard(FiveS) // +5 chips (225, 16)
    // Expected result: 223*16


    //Second round
    //Cards left in hand
    //It's a Pair Combination: (10,2)
    Hand.addCard(SixD) //+6 chips + 4 mult(EvenJ): (16,6)
    Hand.addCard(ThreeD)//+3 chips: (19,6)
    Hand.addCard(ThreeH)//+3 chips: (22, 6)
    // Expected result: 22*4

    assertEquals(Hand.play(List(0,1,2,3,4)),225*16)

    assertEquals(Hand.play(List(0,1,2)), 22*6)

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
    Hand.addCard(AceH)
    val final_score = Hand.play(List(0, 1, 2, 3, 4))
    assertEquals(final_score, 5060)

  test("MaxPlayCountException test (cannot play more than three times)"):
    Hand.addCard(AceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(AceH)
    Hand.addCard(KingD)
    Hand.addCard(ThreeH)
    Hand.play(List(0, 3, 1))
    Hand.play(List(0, 2, 1))
    intercept[MaxPlayCountException]:
      Hand.play(List(0, 1, 2))

  test("cannot play more than 5 cards"):
    Hand.addCard(AceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(AceH)
    val exception = intercept[IllegalArgumentException]:
      Hand.play(List(0, 1, 2, 3, 4, 5))
    assertEquals(exception.getMessage, "Can't discard/play more than 5 cards")


  test("cannot play an invalid index list"):
    Hand.addCard(AceS)
    val exception = intercept[IndexOutOfBoundsException]:
      Hand.play(List(8, -1, 7))
    assertEquals(exception.getMessage, "Can't play/discard with an invalid index list")

  test("cannot play less than 1 card"):
    Hand.addCard(AceS)
    val exception = intercept[IllegalArgumentException]:
      Hand.play(List())
    assertEquals(exception.getMessage, "Can't discard/play less than 1 card")

  // ---- Discarding section ----
  test("cant discard more than 5 cards"):
    Hand.addCard(AceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(AceH)
    val exception = intercept[IllegalArgumentException]:
      Hand.discard(List(0, 1, 2, 3, 4, 5))
    assertEquals(exception.getMessage, "Can't discard/play more than 5 cards")

  test("cant discard less than 1 card"):
    Hand.addCard(JackH)
    val exception = intercept[IllegalArgumentException]:
      Hand.discard(List())
    assertEquals(exception.getMessage, "Can't discard/play less than 1 card")

  test("cant discard an invalid index list"):
    Hand.addCard(KingD)
    val exception = intercept[IndexOutOfBoundsException]:
      Hand.discard(List(8, -1, 7))
    assertEquals(exception.getMessage, "Can't play/discard with an invalid index list")

  test("MaxDiscardCountException test (cannot play more than three times)"):
    Hand.addCard(AceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(AceH)
    Hand.addCard(KingD)
    Hand.addCard(ThreeH)
    Hand.discard(List(0, 1, 2))
    Hand.discard(List(0, 1, 2))
    intercept[MaxDiscardCountException]:
      Hand.discard(List(0, 1, 2))


package cl.uchile.dcc
import munit.FunSuite
import EF2.suits.*
import EF2.*
import EF2.jokers.*
import EF2.exceptions.*
import EF2.ranges.evens.Two
import EF2.ranges.figures.{Jack, King}
import EF2.ranges.odds.{Ace, Three}
import EF2.hand.Hand



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
  var Cards: List[Card] = _
  var Jokers: List[Joker] = _
  var Hand: Hand = _

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
    Cards = List[Card]()
    Jokers = List[Joker]()
    Hand = new Hand(Cards, Jokers)
  }

  test("checkeo de jokers distintos"):
    assert(EvenJ != DeviousJ)

  test("checkeo construccion puntaje con valuees en 0"):
    val zeroScore = new Score(0,0)
    assert(zeroScore.chips == 0)
    assert(zeroScore.multiplier == 0)
  test("checkeo construccion puntaje"):
    assert(score1.chips == 1000)
    assert(score1.multiplier == 3)

  test("checkeo modificacion puntaje (uso de setters)"):
    score1.chips_(100)
    assertEquals(score1.chips, 100)
    score1.multiplier_(5)
    assertEquals(score1.multiplier, 5)

  test("checkeo comparacion puntajes"):
    assert(score1.chips != score2.chips)
    assert(score1.multiplier != score2.multiplier)
    assert(score1.multiplier < score2.multiplier)

  test("checkeo construccion y comparacion cards"):
    assert(LowAceS.range.value == 11)
    assert(LowAceS.range.order == 1)
    assert(LowAceS.range.clasification == ThreeH.range.clasification)
    assert(KingD.range.clasification == JackH.range.clasification)
    assert(HighAceS.range.order == 14)
  test("checkeo de cards de misma suit y diferente value"):
    assert(ThreeH.suit == JackH.suit)
    assert(ThreeH.range.value != JackH.range.value)

  test("mano vacia"):
    assert(Hand.cards.isEmpty)
    assert(Hand.jokers.isEmpty)

  test("añadir una carta a la mano"):
    Hand.addCard(LowAceS)
    assertEquals(Hand.cards.head, LowAceS)
    
  test("quitar una carta a la mano"):
    Hand.addCard(KingD)
    Hand.addCard(ThreeH)
    Hand.removeCard(0)
    assertEquals(Hand.cards.head,ThreeH)

  test("añadir un joker a la mano"):
    Hand.addJoker(DeviousJ)
    assertEquals(Hand.jokers.head,DeviousJ)

  test("quitar un joker a la mano"):
    Hand.addJoker(DeviousJ)
    Hand.addJoker(EvenJ)
    Hand.removeJoker(1)
    assertEquals(Hand.jokers.head, DeviousJ)

  test("jugar una mano"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    val returnedCards = Hand.play(List(0,3,1))
    assertEquals(returnedCards, List[Card](LowAceS,KingD,ThreeH))
    //two cards left in the hand
    assertEquals(Hand.cards.head, TwoC) //the first one should be TwoC
    assertEquals(Hand.cards.last, JackH) //...last one should be JackH

  test("No se puede jugar más de 3 veces un conjunto de cards"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(HighAceS)
    Hand.addCard(KingD)
    Hand.addCard(ThreeH)
    Hand.play(List(0,3,1))
    Hand.play(List(0,2,1))
    intercept[MaxPlayCountException]:
      Hand.play(List(0,1,2))
  test("No se puede jugar más de 5 cards"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(HighAceS)
    intercept[IllegalArgumentException]:
      Hand.play(List(0,1,2,3,4,5))
  test("No se puede jugar una lista de índices inválidos"):
    Hand.addCard(LowAceS)
    intercept[IndexOutOfBoundsException]:
      Hand.play(List(8,-1,7))

  test("No se puede jugar menos de 1 carta"):
    Hand.addCard(HighAceS)
    intercept[IllegalArgumentException]:
      Hand.play(List())
  test("No se puede quitar una carta que no exista en la mano"):
    intercept[IndexOutOfBoundsException]:
      Hand.removeCard(0)

  test("No se puede quitar un joker que no exista en la mano"):
    intercept[IndexOutOfBoundsException]:
      Hand.removeJoker(0)

  test("No se puede descartar más de 3 veces"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(HighAceS)
    Hand.addCard(KingD)
    Hand.addCard(ThreeH)
    Hand.discard(List(0,1,2))
    Hand.discard(List(0,1,2))
    intercept[MaxDiscardCountException]:
      Hand.discard(List(0,1,2))

  test("No se puede descartar más de 5 cards"):
    Hand.addCard(LowAceS)
    Hand.addCard(ThreeH)
    Hand.addCard(TwoC)
    Hand.addCard(KingD)
    Hand.addCard(JackH)
    Hand.addCard(HighAceS)
    intercept[IllegalArgumentException]:
      Hand.discard(List(0, 1, 2, 3, 4, 5))

  test("No se puede descartar menos de 1 carta"):
    Hand.addCard(JackH)
    intercept[IllegalArgumentException]:
      Hand.discard(List())

  test("No se puede descartar una lista de índices inválidos"):
    Hand.addCard(KingD)
    intercept[IndexOutOfBoundsException]:
      Hand.discard(List(8,-1,7))

  test("Una mano no puede tener más de 8 cards"):
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

  test("Una mano no puede tener más de 2 jokers"):
    Hand.addJoker(EvenJ)
    Hand.addJoker(DeviousJ)
    intercept[IllegalArgumentException]:
      Hand.addJoker(GreedyJ)

package cl.uchile.dcc
import munit.FunSuite
import EF2.suits.*
import EF2.*
import EF2.jokers.*
import EF2.exceptions.*
import EF2.ranges.evens.*
import EF2.ranges.figures.*
import EF2.ranges.odds.*
import EF2.hand.Hand
import EF2.combinations.*


class scoringTest extends FunSuite {
  var score: Score = _
  var TwoDiamond: Card = _
  var ThreeDiamond: Card = _
  var FourDiamond: Card = _
  var FiveDiamond: Card = _
  var SixDiamond: Card = _
  var JackClub: Card = _
  var QueenSpades: Card = _
  var AceHeart: Card = _
  var GreedyJ: GreedyJoker = _
  var DeviousJ: DeviousJoker = _
  var EvenJ: EvenJoker = _
  var ScaryF: ScaryFace = _

  override def beforeEach(context: BeforeEach): Unit = {
    score = new Score(0, 0)
    TwoDiamond = new Card(new Two, new Diamond)
    ThreeDiamond = new Card(new Three, new Diamond)
    FourDiamond = new Card(new Four, new Diamond)
    FiveDiamond = new Card(new Five, new Diamond)
    SixDiamond = new Card(new Six, new Diamond)
    JackClub = new Card(new Jack, new Club)
    QueenSpades = new Card(new Queen, new Spades)
    AceHeart = new Card(new Ace(1), new Heart)
    GreedyJ = new GreedyJoker
    DeviousJ = new DeviousJoker
    EvenJ = new EvenJoker
    ScaryF = new ScaryFace
  }

  test("GreedyJoker suma +3 mult por carta de Diamante"):
    val jokers = List(GreedyJ)
    TwoDiamond.applyScore(score, jokers)
    assertEquals(score.multiplier, 3)
    assertEquals(score.chips, 2)

  test("GreedyJoker no afecta cartas que no son Diamante"):
    val jokers = List(GreedyJ)
    JackClub.applyScore(score, jokers)
    assertEquals(score.multiplier, 0)

  test("GreedyJoker acumula +3 por cada carta de Diamante jugada"):
    val jokers = List(GreedyJ)
    TwoDiamond.applyScore(score, jokers)
    ThreeDiamond.applyScore(score, jokers)
    FourDiamond.applyScore(score, jokers)
    FiveDiamond.applyScore(score, jokers)
    SixDiamond.applyScore(score, jokers)
    assertEquals(score.multiplier, 15) // 5 diamantes * 3

  test("EvenJoker suma +4 mult por carta de rango par"):
    val jokers = List(EvenJ)
    TwoDiamond.applyScore(score, jokers)
    assertEquals(score.multiplier, 4)
    assertEquals(score.chips, 2)

  test("EvenJoker no afecta cartas de rango impar"):
    val jokers = List(EvenJ)
    AceHeart.applyScore(score, jokers)
    assertEquals(score.multiplier, 0)

  test("EvenJoker no afecta cartas de rango figura"):
    val jokers = List(EvenJ)
    JackClub.applyScore(score, jokers)
    assertEquals(score.multiplier, 0)

  test("ScaryFace suma +30 chips por carta figura"):
    val jokers = List(ScaryF)
    JackClub.applyScore(score, jokers)
    assertEquals(score.chips, 40)

  test("ScaryFace no afecta cartas que no son figura"):
    val jokers = List(ScaryF)
    TwoDiamond.applyScore(score, jokers)
    assertEquals(score.chips, 2)

  test("DeviousJoker suma +100 chips si la combinacion es Straight"):
    val straight = new Straight
    straight.applyScore(score, DeviousJ)
    assertEquals(score.chips, 100)

  test("DeviousJoker suma +100 chips si la combinacion es StraightFlush"):
    val straightFlush = new StraightFlush
    straightFlush.applyScore(score, DeviousJ)
    assertEquals(score.chips, 100)

  test("DeviousJoker no afecta otras combinaciones"):
    val highCard = new HighCard
    highCard.applyScore(score, DeviousJ)
    assertEquals(score.chips, 0)

  test("GreedyJoker y EvenJoker acumulan correctamente sobre carta par de Diamante"):
    val jokers = List(GreedyJ, EvenJ)
    TwoDiamond.applyScore(score, jokers)
    assertEquals(score.chips, 2)
    assertEquals(score.multiplier, 7) //

  test("ejemplo del enunciado - Straight Flush con GreedyJoker y DeviousJoker"):
    val jokers = List(GreedyJ, DeviousJ)
    val straightFlush = new StraightFlush
    // inicializar con puntaje base de la combinacion
    score.chips_(100)
    score.multiplier_(8)
    // aporte de cada carta
    val playedCards = List(TwoDiamond, ThreeDiamond, FourDiamond, FiveDiamond, SixDiamond)
    for (card <- playedCards) {
      card.applyScore(score, jokers)
    }
    // aplicar DeviousJoker sobre la combinacion
    straightFlush.applyScore(score, DeviousJ)
    assertEquals(score.chips, 220) // 100 + 2+3+4+5+6 + 100
    assertEquals(score.multiplier, 23) // 8 + 15
}

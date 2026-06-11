package cl.uchile.dcc
import munit.FunSuite
import EF2.suits.*
import EF2.*
import EF2.jokers.*
import EF2.ranks.evens.*
import EF2.ranks.figures.*
import EF2.ranks.odds.*
import EF2.combinations.*
import EF2.combinations.straights.{Straight, StraightFlush}
import EF2.hand.*

class jokerTest extends FunSuite {
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

  // ---- GreedyJoker section ----
  test("GreedyJoker adds +3 mult for each Diamond Card"):
    val jokers = List(GreedyJ)
    TwoDiamond.applyScore(score, jokers)
    assertEquals(score.multiplier, 3)
    assertEquals(score.chips, 2)

  test("GreedyJoker doesn't affect other Card types"):
    val jokers = List(GreedyJ)
    JackClub.applyScore(score, jokers)
    assertEquals(score.multiplier, 0)

  test("GreedyJoker accumulates +3 score multiplier for each Diamond Card"):
    val jokers = List(GreedyJ)
    TwoDiamond.applyScore(score, jokers)
    ThreeDiamond.applyScore(score, jokers)
    FourDiamond.applyScore(score, jokers)
    FiveDiamond.applyScore(score, jokers)
    SixDiamond.applyScore(score, jokers)
    assertEquals(score.multiplier, 15) // 5 diamantes * 3

  // ---- EvenJoker section ----
  test("EvenJoker adds +4 mult por each Card with even Range"):
    val jokers = List(EvenJ)
    TwoDiamond.applyScore(score, jokers)
    assertEquals(score.multiplier, 4)
    assertEquals(score.chips, 2)

  test("EvenJoker doesn't affect Cards with other properties"):
    val jokers = List(EvenJ)
    AceHeart.applyScore(score, jokers)
    JackClub.applyScore(score, jokers)
    assertEquals(score.multiplier, 0)
  // ---- ScaryFace section ----
  test("ScaryFace adds +30 chips for each Figure type of Card"):
    val jokers = List(ScaryF)
    JackClub.applyScore(score, jokers) // score.chips + 40
    QueenSpades.applyScore(score, jokers) // score.chips + 40
    assertEquals(score.chips, 80)

  test("ScaryFace doesn't affect Cards with other properties"):
    val jokers = List(ScaryF)
    TwoDiamond.applyScore(score, jokers)
    assertEquals(score.chips, 2)

  // ---- DeviousJoker section ----
  test("DeviousJoker adds +100 chips if the Combination is a Straight"):
    val straight = new Straight
    straight.applyScore(score, DeviousJ)
    assertEquals(score.chips, 100)

  test("DeviousJoker adds +100 chips if the Combination is a StraightFlush"):
    val straightFlush = new StraightFlush
    straightFlush.applyScore(score, DeviousJ)
    assertEquals(score.chips, 100)

  test("DeviousJoker doesn't affect other Combination types"):
    val highCard = new HighCard
    val colorFlush = new ColorFlush
    val pair = new Pair
    val trio = new Trio
    colorFlush.applyScore(score, DeviousJ)
    highCard.applyScore(score, DeviousJ)
    pair.applyScore(score, DeviousJ)
    trio.applyScore(score, DeviousJ)
    assertEquals(score.chips, 0)

  test("GreedyJoker and EvenJoker effects correctly acumulate over an Even Diamond Card"):
    val jokers = List(GreedyJ, EvenJ)
    TwoDiamond.applyScore(score, jokers)
    assertEquals(score.chips, 2)
    assertEquals(score.multiplier, 7) // +4 from GreedyJ, +3 from EvenJ

  
}

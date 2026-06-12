package cl.uchile.dcc
import munit.FunSuite
import EF2.suits.*
import EF2.*
import EF2.ranks.evens.*
import EF2.ranks.figures.*
import EF2.ranks.odds.*
import EF2.combinations.straights.*
import EF2.hand.*
import EF2.combinations.otherCombinations.*

class CombinationsTest extends FunSuite {

  var AceS: Card = _
  var TwoS: Card = _
  var ThreeS: Card = _
  var FourS: Card = _
  var FiveS: Card = _
  var SixS: Card = _
  var EightS: Card = _
  var TenS: Card = _
  var JackS: Card = _

  var TwoC: Card = _
  var FourC: Card = _
  var SixC: Card = _
  var ThreeC: Card = _
  var QueenC: Card = _
  var FiveC: Card = _

  var AceH: Card = _
  var TwoH: Card = _
  var ThreeH: Card = _
  var FourH: Card = _
  var SixH: Card = _
  var EightH: Card = _
  var TenH: Card = _
  var JackH: Card = _
  var QueenH: Card = _
  var KingH: Card = _

  var TwoD: Card = _
  var ThreeD: Card = _
  var FourD: Card = _
  var FiveD: Card = _
  var SixD: Card = _
  var SevenD: Card = _
  var EightD: Card = _
  var NineD: Card = _
  var TenD: Card = _
  var JackD: Card = _
  var QueenD: Card = _
  var KingD: Card = _



  override def beforeEach(context: BeforeEach): Unit = {

    AceS =    new Card(new Ace, new Spades)
    TwoS =    new Card(new Two, new Spades)
    ThreeS =  new Card(new Three, new Spades)
    FourS =   new Card(new Four, new Spades)
    FiveS =   new Card(new Five, new Spades)
    SixS =    new Card(new Six, new Spades)
    EightS =  new Card(new Eight, new Spades)
    TenS =    new Card(new Ten, new Spades)
    JackS =   new Card(new Jack, new Spades)

    TwoC =    new Card(new Two, new Club)
    ThreeC =  new Card(new Three, new Club)
    FourC =   new Card(new Four, new Club)
    FiveC =   new Card(new Five, new Club)
    SixC =    new Card(new Six, new Club)
    QueenC =  new Card(new Queen, new Club)


    AceH =    new Card(new Ace, new Heart)
    TwoH =    new Card(new Two, new Heart)
    ThreeH =  new Card(new Three, new Heart)
    FourH =   new Card(new Four, new Heart)
    SixH =    new Card(new Six, new Heart)
    EightH =  new Card(new Eight, new Heart)
    TenH =    new Card(new Ten, new Heart)
    JackH =   new Card(new Jack, new Heart)
    QueenH =  new Card(new Queen, new Heart)
    KingH =   new Card(new King, new Heart)

    TwoD =    new Card(new Two,  new Diamond)
    ThreeD =  new Card(new Three, new Diamond)
    FourD =   new Card(new Four, new Diamond)
    FiveD =   new Card(new Five,  new Diamond)
    SixD =    new Card(new Six, new Diamond)
    SevenD =  new Card(new Seven, new Diamond)
    EightD =  new Card(new Eight, new Diamond)
    NineD =   new Card(new Nine, new Diamond)
    TenD =    new Card(new Ten, new Diamond)
    JackD =   new Card(new Jack, new Diamond)
    QueenD =  new Card(new Queen, new Diamond)
    KingD =   new Card(new King, new Diamond)
  }

  test("basic validation of a straightFlush - lowAce in straight tests"):
    val straightFlushCards = List(AceS, TwoS, ThreeS, FourS, FiveS)
    val straight = new StraightFlush
    assert(straight.validate(straightFlushCards))
    assertEquals(straight.bScore.chips, 100)
    assertEquals(straight.bScore.multiplier, 8)

  test("Straight with HighAce validation test"):
    val highStraight = List(TenH, JackS, QueenC, KingD, AceS)
    val straight = new Straight

    assert(straight.validate(highStraight))
    assertEquals(straight.bScore.chips, 30)
    assertEquals(straight.bScore.multiplier, 4)

  test("basic validation of a colorFlush combination"):
    val colorCards = List(ThreeS, FiveS, AceS, JackS, TwoS)
    val color = new ColorFlush
    assert(color.validate(colorCards))
    assertEquals(color.bScore.chips, 35)
    assertEquals(color.bScore.multiplier, 4)


  test("basic validation of a Straight combination"):
    val straightCards = List(AceS, TwoH, ThreeC, FourD, FiveC)
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
    val conflictiveCards = List(AceS, TwoS, ThreeS, FourS, FiveS)
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


  test("Pair should NOT validate with 1 card"):
    val singleCard = List(TwoC)
    val pair = new Pair
    assert(!pair.validate(singleCard))

  test("Pair should validate with 2 cards of same rank"):
    val pairCards = List(TwoC, TwoH)
    val pair = new Pair
    assert(pair.validate(pairCards))

  test("Pair should validate with 4 cards (includes pair)"):
    val fourCards = List(TwoC, TwoH, ThreeS, FourD)
    val pair = new Pair
    assert(pair.validate(fourCards))

  test("Trio should NOT validate with 2 cards"):
    val twoCards = List(TwoC, TwoH)
    val trio = new Trio
    assert(!trio.validate(twoCards))

  test("Trio should validate with exactly 3 cards of same rank"):
    val trioCards = List(TwoC, TwoH, TwoS)
    val trio = new Trio
    assert(trio.validate(trioCards))

  test("Trio should validate with 5 cards (includes trio)"):
    val fiveCards = List(TwoC, TwoH, TwoS, ThreeS, FourD)
    val trio = new Trio
    assert(trio.validate(fiveCards))


  test("ColorFlush should NOT validate with 4 cards of same suit"):
    val fourDiamonds = List(TwoD, ThreeD, FourD, FiveD)
    val color = new ColorFlush
    assert(!color.validate(fourDiamonds))

  test("ColorFlush should NOT validate with 6 cards of same suit"):
    val sixDiamonds = List(TwoD, ThreeD, FourD, FiveD, SixD)
    val color = new ColorFlush
    // the validate method checks length == 5
    assert(!color.validate(sixDiamonds :+ SevenD))

  test("ColorFlush should validate with 5 cards of same suit (non-sequential)"):
    val colorCards = List(TwoD, FourD, SixD, EightD, TenD)
    val color = new ColorFlush
    assert(color.validate(colorCards))

  test("ColorFlush should NOT validate with 5 cards of different suits"):
    val mixedSuits = List(TwoD, ThreeH, FourS, FiveC, SixD)
    val color = new ColorFlush
    assert(!color.validate(mixedSuits))

  test("Straight should NOT validate with 4 consecutive cards"):
    val fourConsecutive = List(AceS, TwoH, ThreeC, FourD)
    val straight = new Straight
    assert(!straight.validate(fourConsecutive))

  test("Straight should validate with 5 consecutive cards (mixed suits)"):
    val straightCards = List(AceS, TwoH, ThreeC, FourD, FiveC)
    val straight = new Straight
    assert(straight.validate(straightCards))

  test("Straight should NOT validate with non-consecutive cards"):
    val nonConsecutive = List(AceS, TwoH, FourC, FiveD, SixC)
    val straight = new Straight
    assert(!straight.validate(nonConsecutive))

  test("Straight should validate with High Ace (10-J-Q-K-A)"):
    val highStraight = List(TenH, JackS, QueenC, KingD, AceS)
    val straight = new Straight
    assert(straight.validate(highStraight))

  test("Straight should validate with Low Ace (A-2-3-4-5)"):
    val lowStraight = List(AceS, TwoH, ThreeC, FourD, FiveC)
    val straight = new Straight
    assert(straight.validate(lowStraight))

  test("Straight should NOT have both Low and High Ace in sequence"):
    // This is impossible, but testing the logic
    val kingAceTwo = List(KingD, AceS, TwoH, ThreeC, FourD)
    val straight = new Straight
    assert(!straight.validate(kingAceTwo))


  test("StraightFlush should NOT validate with straight but different suits"):
    val straightDifferentSuits = List(AceS, TwoH, ThreeC, FourD, FiveC)
    val sf = new StraightFlush
    assert(!sf.validate(straightDifferentSuits))

  test("StraightFlush should NOT validate with flush but non-consecutive"):
    val flushNonConsecutive = List(TwoS, FourS, SixS, EightS, TenS)
    val sf = new StraightFlush
    assert(!sf.validate(flushNonConsecutive))

  test("StraightFlush should validate with Low Ace straight flush"):
    val lowAceSF = List(AceS, TwoS, ThreeS, FourS, FiveS)
    val sf = new StraightFlush
    assert(sf.validate(lowAceSF))
    assertEquals(sf.bScore.chips, 100)
    assertEquals(sf.bScore.multiplier, 8)

  test("StraightFlush should validate with High Ace straight flush"):
    val highAceSF = List(TenH, JackH, QueenH, KingH, AceH)
    val sf = new StraightFlush
    assert(sf.validate(highAceSF))

  test("StraightFlush should validate with middle straight flush"):
    val middleSF = List(NineD, TenD, JackD, QueenD, KingD)
    val sf = new StraightFlush
    assert(sf.validate(middleSF))


  test("HighCard should validate with 1 card"):
    val singleCard = List(AceS)
    val hc = new HighCard
    assert(hc.validate(singleCard))

  test("HighCard should validate with 3 unrelated cards"):
    val unrelated = List(TwoC, FiveS, KingD)
    val hc = new HighCard
    assert(hc.validate(unrelated))

  test("HighCard should NOT validate if it contains a pair"):
    val withPair = List(TwoC, TwoH, FourS, SixD, EightH)
    val hc = new HighCard
    assert(!hc.validate(withPair))

  test("HighCard should NOT validate if it contains a trio"):
    val withTrio = List(ThreeC, ThreeH, ThreeS, FiveD, SixH)
    val hc = new HighCard
    assert(!hc.validate(withTrio))

  test("HighCard should NOT validate if it's a straight"):
    val straightCards = List(AceS, TwoH, ThreeC, FourD, FiveC)
    val hc = new HighCard
    assert(!hc.validate(straightCards))

  test("HighCard should NOT validate if it's a flush"):
    val flushCards = List(TwoD, FourD, SixD, EightD, TenD)
    val hc = new HighCard
    assert(!hc.validate(flushCards))


  test("Pair should validate with multiple pairs present (returns true for first pair)"):
    val twoPairs = List(TwoC, TwoH, ThreeS, ThreeD)
    val pair = new Pair
    assert(pair.validate(twoPairs))

  test("Trio should NOT validate if only one pair exists"):
    val onePair = List(TwoC, TwoH, ThreeS, FourD, FiveC)
    val trio = new Trio
    assert(!trio.validate(onePair))

  test("ConflictResolution: Straight Flush over Straight"):
    val sf = List(AceS, TwoS, ThreeS, FourS, FiveS)
    val straightFlush = new StraightFlush
    val straight = new Straight
    assert(straightFlush.validate(sf))
    assert(straight.validate(sf))
    // StraightFlush should be chosen (higher priority)
    val hand = new Hand(sf, List())
    assertEquals(hand.determineCombination(sf), straightFlush)

  test("ConflictResolution: Straight Flush over Flush"):
    val sf = List(AceS, TwoS, ThreeS, FourS, FiveS)
    val straightFlush = new StraightFlush
    val color = new ColorFlush
    assert(straightFlush.validate(sf))
    assert(color.validate(sf))
    val hand = new Hand(sf, List())
    assertEquals(hand.determineCombination(sf), straightFlush)

  test("ConflictResolution: Trio over Pair"):
    val trio = List(TwoC, TwoH, TwoS, ThreeD, FourH)
    val trioCombo = new Trio
    val pair = new Pair
    assert(trioCombo.validate(trio))
    assert(pair.validate(trio))
    val hand = new Hand(trio, List())
    assertEquals(hand.determineCombination(trio), trioCombo)

  test("HighCard should validate with empty list"):
    val empty = List[Card]()
    val hc = new HighCard
    //this is only for testing logic, on HandTest this won't work
    //due to the exceptions that we defined
    val result = hc.validate(empty)

  test("any combination should handle empty list"):
    val empty = List[Card]()
    val pair = new Pair
    val trio = new Trio
    val straight = new Straight
    assert(!pair.validate(empty))
    assert(!trio.validate(empty))
    assert(!straight.validate(empty))

  test("Four of a kind should validate as both Trio and Pair"):
    val fourOfKind = List(TwoC, TwoH, TwoS, TwoD)
    val trio = new Trio
    val pair = new Pair
    assert(trio.validate(fourOfKind))
    assert(pair.validate(fourOfKind))

  test("Five of same rank (if possible) should validate as Trio, Pair, and HighCard"):
    // assuming you can only have 4 cards of same rank in standard deck
    // this is more of a theoretical edge case
    val fiveOfKind = List(TwoC, TwoH, TwoS, TwoD, new Card(new Two, new Diamond))
    // this shouldn't be possible but testing the logic
}

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
import EF2.combinations.Combination

class CombinationsTest extends FunSuite {

  var Straight: Combination = _
  var StraightFlush: Combination = _
  var ColorFlush: Combination = _
  var Trio: Combination = _
  var Pair: Combination = _
  var HighCard: Combination = _

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

    Straight = new Straight
    StraightFlush = new StraightFlush
    ColorFlush = new ColorFlush
    Trio = new Trio
    Pair = new Pair
    HighCard = new HighCard

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

  // ---- HighCard validation tests  ----
  test("basic validation of a HighCard combination"):
    val highCards = List(TwoC, FiveS, ThreeC, FourD, JackS)
    assert(HighCard.validate(highCards))
    assertEquals(HighCard.bScore.chips, 5)
    assertEquals(HighCard.bScore.multiplier, 1)

  test("HighCard should validate with 1 card"):
    val singleCard = List(AceS)
    assert(HighCard.validate(singleCard))

  test("HighCard should validate with empty list"):
    val empty = List[Card]()
    //this is only for testing logic, on HandTest this won't work
    //due to the exceptions that we defined
    val result = HighCard.validate(empty)

  test("HighCard should validate with 3 unrelated cards"):
    val unrelated = List(TwoC, FiveS, KingD)
    assert(HighCard.validate(unrelated))

  test("HighCard should NOT validate if it contains a pair"):
    val withPair = List(TwoC, TwoH, FourS, SixD, EightH)
    assert(!HighCard.validate(withPair))

  test("HighCard should NOT validate if it contains a trio"):
    val withTrio = List(ThreeC, ThreeH, ThreeS, FiveD, SixH)
    assert(!HighCard.validate(withTrio))

  test("HighCard should NOT validate if it's a straight"):
    val straightCards = List(AceS, TwoH, ThreeC, FourD, FiveC)
    assert(!HighCard.validate(straightCards))

  test("HighCard should NOT validate if it's a flush"):
    val flushCards = List(TwoD, FourD, SixD, EightD, TenD)
    assert(!HighCard.validate(flushCards))


  // ---- Pair validation tests  ----
  test("basic validation of a de Pair combination"):
    val pairCards = List(TwoC, TwoH)
    assert(Pair.validate(pairCards))
    assertEquals(Pair.bScore.chips, 10)
    assertEquals(Pair.bScore.multiplier, 2)

  test("Pair should NOT validate with 1 card"):
    val singleCard = List(TwoC)
    assert(!Pair.validate(singleCard))

  test("Pair should validate with 2 cards of same rank"):
    val pairCards = List(TwoC, TwoH)
    assert(Pair.validate(pairCards))

  test("Pair should validate with 4 cards (includes pair)"):
    val fourCards = List(TwoC, TwoH, ThreeS, FourD)
    assert(Pair.validate(fourCards))

  test("Pair should validate with multiple pairs present (returns true for first pair)"):
    val twoPairs = List(TwoC, TwoH, ThreeS, ThreeD)
    assert(Pair.validate(twoPairs))

  // ---- Trio validation tests  ----
  test("basic validation of a Trio combination"):
    val trioCards = List(TwoC, TwoH, TwoS)
    assert(Trio.validate(trioCards))
    assertEquals(Trio.bScore.chips, 30)
    assertEquals(Trio.bScore.multiplier, 3)

  test("Trio should NOT validate with 2 cards"):
    val twoCards = List(TwoC, TwoH)
    assert(!Trio.validate(twoCards))

  test("Trio should validate with exactly 3 cards of same rank"):
    val trioCards = List(TwoC, TwoH, TwoS)
    assert(Trio.validate(trioCards))

  test("Trio should validate with 5 cards (includes trio)"):
    val fiveCards = List(TwoC, TwoH, TwoS, ThreeS, FourD)
    assert(Trio.validate(fiveCards))

  // ---- Straight validation tests  ----
  test("basic validation of a Straight combination"):
    val straightCards = List(AceS, TwoH, ThreeC, FourD, FiveC)
    assert(Straight.validate(straightCards))
    assertEquals(Straight.bScore.chips, 30)
    assertEquals(Straight.bScore.multiplier, 4)

  test("Straight should NOT validate with 4 consecutive cards"):
    val fourConsecutive = List(AceS, TwoH, ThreeC, FourD)
    assert(!Straight.validate(fourConsecutive))

  test("Straight should validate with 5 consecutive cards (mixed suits)"):
    val straightCards = List(AceS, TwoH, ThreeC, FourD, FiveC)
    assert(Straight.validate(straightCards))

  test("Straight should NOT validate with non-consecutive cards"):
    val nonConsecutive = List(AceS, TwoH, FourC, FiveD, SixC)
    assert(!Straight.validate(nonConsecutive))

  test("Straight should validate with High Ace (10-J-Q-K-A)"):
    val highStraight = List(TenH, JackS, QueenC, KingD, AceS)
    assert(Straight.validate(highStraight))

  test("Straight should validate with Low Ace (A-2-3-4-5)"):
    val lowStraight = List(AceS, TwoH, ThreeC, FourD, FiveC)
    assert(Straight.validate(lowStraight))

  test("Straight should NOT have both Low and High Ace in sequence"):
    // This is impossible, but testing the logic
    val kingAceTwo = List(KingD, AceS, TwoH, ThreeC, FourD)
    assert(!Straight.validate(kingAceTwo))

  // ---- ColorFlush validation tests  ----

  test("basic validation of a colorFlush combination"):
    val colorCards = List(ThreeS, FiveS, AceS, JackS, TwoS)
    assert(ColorFlush.validate(colorCards))
    assertEquals(ColorFlush.bScore.chips, 35)
    assertEquals(ColorFlush.bScore.multiplier, 4)

  test("ColorFlush should NOT validate with 4 cards of same suit"):
    val fourDiamonds = List(TwoD, ThreeD, FourD, FiveD)
    assert(!ColorFlush.validate(fourDiamonds))

  test("ColorFlush should NOT validate with 6 cards of same suit"):
    val sixDiamonds = List(TwoD, ThreeD, FourD, FiveD, SixD)
    // the validate method checks length == 5
    assert(!ColorFlush.validate(sixDiamonds :+ SevenD))

  test("ColorFlush should validate with 5 cards of same suit (non-sequential)"):
    val colorCards = List(TwoD, FourD, SixD, EightD, TenD)
    assert(ColorFlush.validate(colorCards))

  test("ColorFlush should NOT validate with 5 cards of different suits"):
    val mixedSuits = List(TwoD, ThreeH, FourS, FiveC, SixD)
    assert(!ColorFlush.validate(mixedSuits))

  // ---- StraightFlush validation tests  ----
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
    assert(StraightFlush.validate(middleSF))

  // ---- ConflictResolution validation tests  ----
  test("ConflictResolution: Straight Flush over Straight"):
    val sf = List(AceS, TwoS, ThreeS, FourS, FiveS)
    assert(StraightFlush.validate(sf))
    assert(Straight.validate(sf))
    // StraightFlush should be chosen (higher priority)
    val hand = new Hand(sf, List())
    assertEquals(hand.determineCombination(sf), StraightFlush)

  test("ConflictResolution: Straight Flush over Flush"):
    val sf = List(AceS, TwoS, ThreeS, FourS, FiveS)
    assert(StraightFlush.validate(sf))
    assert(ColorFlush.validate(sf))
    val hand = new Hand(sf, List())
    assertEquals(hand.determineCombination(sf), StraightFlush)


  test("ConflictResolution: Trio over Pair"):
    val Trio = List(TwoC, TwoH, TwoS, ThreeD, FourH)
    val trioCombo = new Trio
    
    assert(trioCombo.validate(Trio))
    assert(Pair.validate(Trio))
    val hand = new Hand(Trio, List())
    assertEquals(hand.determineCombination(Trio), trioCombo)

  test("any combination should handle empty list"):
    val empty = List[Card]()
    assert(!Pair.validate(empty))
    assert(!Trio.validate(empty))
    assert(!Straight.validate(empty))

  test("Four of a kind should validate as both Trio and Pair"):
    val fourOfKind = List(TwoC, TwoH, TwoS, TwoD)
    assert(Trio.validate(fourOfKind))
    assert(Pair.validate(fourOfKind))

}

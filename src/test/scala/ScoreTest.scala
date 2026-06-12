package cl.uchile.dcc
import munit.FunSuite
import EF2.Score

class ScoreTest extends FunSuite{
  var score2: Score = _
  var score1: Score = _

  override def beforeEach(context: BeforeEach): Unit = {
    score1 = new Score(1000, 3)
    score2 = new Score(300, 10)
  }

  test("construction of score with zero values test (using getters)"):
    val zeroScore = new Score(0, 0)
    assertEquals(zeroScore.chips, 0)
    assertEquals(zeroScore.multiplier, 0)

  test("using getters test"):
    assertEquals(score1.chips, 1000)
    assertEquals(score1.multiplier, 3)

  test("using setters test"):
    score1.chips_(100)
    assertEquals(score1.chips, 100)
    score1.multiplier_(5)
    assertEquals(score1.multiplier, 5)

  test("comparing scores test"):
    assert(score1.chips != score2.chips)
    assert(score1.multiplier != score2.multiplier)
    assert(score1.multiplier < score2.multiplier)

  test("comparing scores test after modifying components (using getters)"):
    score1.chips_(300)
    score1.multiplier_(10)
    assertEquals(score1.chips, score2.chips)
    assertEquals(score1.multiplier, score2.multiplier)


}

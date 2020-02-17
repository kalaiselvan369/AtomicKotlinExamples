// NestedClasses/NestedEx1.kt
package nestedclassesex1
import atomictest.*
import nestedclassesex1.GridGame.Mark.*
import kotlin.random.Random

interface GridGame {
  enum class Mark { BLANK, X, O }
}

class FillIt(
  val side: Int = 3, randomSeed: Int = 0
) : GridGame {
  val rand = Random(randomSeed)
  private var grid =
    MutableList(side * side) { BLANK }
  private var player = X
  fun turn(): Boolean {
    val blanks = grid.withIndex()
      .filter { it.value == BLANK }
    if (blanks.isEmpty())
      return false
    grid[blanks.random(rand).index] = player
    player = if (player == X) O else X
    return true
  }
  fun play() {
    while (turn())
      ;
  }
  override fun toString() =
    grid.chunked(side).joinToString("\n")
}

fun main() {
  val game = FillIt(8, 17)
  game.play()
  Trace(game) eq """
  [O, X, O, X, O, X, X, X]
  [X, O, O, O, O, O, X, X]
  [O, O, X, O, O, O, X, X]
  [X, O, O, O, O, O, X, O]
  [X, X, O, O, X, X, X, O]
  [X, X, O, O, X, X, O, X]
  [O, X, X, O, O, O, X, O]
  [X, O, X, X, X, O, X, X]
  """
}
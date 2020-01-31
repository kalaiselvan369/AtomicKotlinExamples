// RobotExplorer2/View2.kt
package robotexplorer2

class View(private val stage: Stage) {
  // Start an ANSI terminal control string:
  private val ansiTerm = "\u001B["
  fun clear() {
    val size = stage.maze.lines().size + 3
    print("${ansiTerm}${size}T")
  }
  private fun mazeView(): String {
    var result = ""
    var currentRow = 0
    stage.rooms.forEach { (pair, room) ->
      val row = pair.first
      if (row != currentRow) {
        result += "\n"
        currentRow = row
      }
      result += if (room == stage.robot.room)
        "${stage.robot.id()}" else
        "${room.player.id()}"
    }
    return result +
      "\n\nEnergy: ${stage.robot.energy}\n"
  }
  fun show() {
    print("${ansiTerm}0;0H") // Cursor home
    println(mazeView())
    Thread.sleep(300L) // Pause
  }
}
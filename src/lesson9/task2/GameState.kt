package lesson9.task2

import lesson9.task1.Cell
import lesson9.task1.Matrix
import kotlin.math.abs

class GameState(val matrix: Matrix<Int>, val move: Int, val previousState: GameState?, val zeroCoords: Cell) {

    val f: Int

    init {
        f = f()
    }

    fun manhDistance(): Int {
        var result = 0
        for (i in 0 until matrix.height) {
            for (j in 0 until matrix.width) {
                var value = matrix[i, j] - 1
                while (value < 0) {
                    value += matrix.height * matrix.width
                }
                val coordinates = getCoordinates(value)
                result += abs(i - coordinates.first) + abs(j - coordinates.second)
            }
        }
        return result
    }

    /*fun lastMove(): Int {
        if (matrix[matrix.height - 1, matrix.width - 1] == matrix.height * matrix.width - 1
            || matrix[matrix.height - 1, matrix.width - 1] == matrix.height * (matrix.width - 1)
        ) return 0
        return 2
    }*/

    fun lastNode(): String = matrix.toString()

    fun h(): Int = manhDistance() /*+ lastMove()*/

    fun f(): Int = h()

    fun getNeighbours(): List<Cell> {
        val neighs = mutableListOf<Cell>()
        val zeroCords = getElementId(0)

        val first = zeroCords.first
        val second = zeroCords.second

        if (second != 0) neighs.add(
            Cell(first, second - 1)
        )

        if (second != 3) neighs.add(
            Cell(first, second + 1)
        )

        if (first != 0) neighs.add(
            Cell(first - 1, second)
        )

        if (first != 3) neighs.add(
            Cell(first + 1, second)
        )

        return neighs
    }

    override fun hashCode(): Int = 31 * f + zeroCoords.row * zeroCoords.column

    override fun equals(other: Any?): Boolean {
        if (other !is GameState) return false
        return other.matrix == matrix
    }

    // value between -1 to height * width - 2
    // value of "pyatnashka" - 1
    fun getCoordinates(value: Int) =
        value / matrix.height to value % matrix.width

    fun getElementId(el: Int): Pair<Int, Int> {
        for (i in 0 until matrix.height) {
            for (j in 0 until matrix.width) {
                if (matrix[i, j] == el) return i to j
            }
        }
        return -1 to -1
    }
}

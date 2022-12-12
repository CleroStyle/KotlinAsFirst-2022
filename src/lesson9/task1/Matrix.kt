@file:Suppress("UNUSED_PARAMETER", "unused")

package lesson9.task1

import lesson9.task2.GameState
import kotlin.math.abs

/*import lesson9.task2.createNewMatrix*/

// Урок 9: проектирование классов
// Максимальное количество баллов = 40 (без очень трудных задач = 15)

/**
 * Ячейка матрицы: row = ряд, column = колонка
 */
data class Cell(val row: Int, val column: Int)

/**
 * Интерфейс, описывающий возможности матрицы. E = тип элемента матрицы
 */
interface Matrix<E> {
    /** Высота */
    val height: Int

    /** Ширина */
    val width: Int

    val field: MutableList<E>

    /**
     * Доступ к ячейке.
     * Методы могут бросить исключение, если ячейка не существует или пуста
     */
    operator fun get(row: Int, column: Int): E

    operator fun get(cell: Cell): E

    /**
     * Запись в ячейку.
     * Методы могут бросить исключение, если ячейка не существует
     */
    operator fun set(row: Int, column: Int, value: E)

    operator fun set(cell: Cell, value: E)
}

/**
 * Простая (2 балла)
 *
 * Метод для создания матрицы, должен вернуть РЕАЛИЗАЦИЮ Matrix<E>.
 * height = высота, width = ширина, e = чем заполнить элементы.
 * Бросить исключение IllegalArgumentException, если height или width <= 0.
 */
fun <E> createMatrix(height: Int, width: Int, e: E): Matrix<E> = MatrixImpl(height, width, e)

/**
 * Средняя сложность (считается двумя задачами в 3 балла каждая)
 *
 * Реализация интерфейса "матрица"
 */
class MatrixImpl<E>(
    override val height: Int, override val width: Int, e: E
) : Matrix<E> {
    val list = mutableListOf<E>()
    override val field: MutableList<E>
        get() = list

    init {
        if (!(height > 0 && width > 0)) throw IllegalArgumentException()
        for (i in 0 until height * width) {
            list.add(e)
        }
    }

    override fun get(row: Int, column: Int): E = list[row * width + column]

    override fun get(cell: Cell): E = list[cell.row * width + cell.column]

    override fun set(row: Int, column: Int, value: E) {
        list[row * width + column] = value
    }

    override fun set(cell: Cell, value: E) {
        list[cell.row * width + cell.column] = value
    }

    override fun equals(other: Any?): Boolean {
        if (other !is MatrixImpl<*>
            || other.width != width
            || other.height != height
        ) return false

        for (i in 0 until height) {
            for (j in 0 until width) {
                if (other[i, j] != get(i, j)) {
                    return false
                }
            }
        }

        return true
    }

    override fun toString(): String {
        val result = StringBuilder()
        result.append(System.lineSeparator())
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (get(i, j).toString().length == 1) result.append("${get(i, j)}  ")
                else result.append("${get(i, j)} ")
            }
            result.append(System.lineSeparator())
        }
        return result.toString()
    }
}

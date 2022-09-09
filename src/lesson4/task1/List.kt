@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.lowercase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> = TODO()

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var number: Int = n
    var counter = 0
    while (number != 0) {
        counter++
        number /= 10
    }

    var result = ""

    while (counter > 0) {
        when (counter) {
            1 -> when (n % 10) {
                1 -> {
                    result += " один"
                    break
                }

                2 -> {
                    result += " два"
                    break
                }

                3 -> {
                    result += " три"
                    break
                }

                4 -> {
                    result += " четыре"
                    break
                }

                5 -> {
                    result += " пять"
                    break
                }

                6 -> {
                    result += " шесть"
                    break
                }

                7 -> {
                    result += " семь"
                    break
                }

                8 -> {
                    result += " восемь"
                    break
                }

                9 -> {
                    result += " девять"
                    break
                }

                else -> break
            }

            2 -> when (n % 100 / 10) {
                1 -> when (n % 10) {
                    1 -> {
                        result += " одиннадцать"
                        break
                    }

                    2 -> {
                        result += " двенадцать"
                        break
                    }

                    3 -> {
                        result += " тринадцать"
                        break
                    }

                    4 -> {
                        result += " четырнадцать"
                        break
                    }

                    5 -> {
                        result += " пятнадцать"
                        break
                    }

                    6 -> {
                        result += " шестнадцать"
                        break
                    }

                    7 -> {
                        result += " семнадцать"
                        break
                    }

                    8 -> {
                        result += " восемнадцать"
                        break
                    }

                    9 -> {
                        result += " девятнадцать"
                        break
                    }

                    0 -> {
                        result += " десять"
                        break
                    }
                }

                2 -> {
                    result += " двадцать"
                    counter--
                }

                3 -> {
                    result += " тридцать"
                    counter--
                }

                4 -> {
                    result += " сорок"
                    counter--
                }

                5 -> {
                    result += " пятьдесят"
                    counter--
                }

                6 -> {
                    result += " шестьдесят"
                    counter--
                }

                7 -> {
                    result += " семьдесят"
                    counter--
                }

                8 -> {
                    result += " восемьдесят"
                    counter--
                }

                9 -> {
                    result += " девяносто"
                    counter--
                }

                else -> {
                    counter--
                }
            }

            3 -> when (n % 1000 / 100) {
                1 -> {
                    result += " сто"
                    counter--
                }

                2 -> {
                    result += " двести"
                    counter--
                }

                3 -> {
                    result += " триста"
                    counter--
                }

                4 -> {
                    result += " четыреста"
                    counter--
                }

                5 -> {
                    result += " пятьсот"
                    counter--
                }

                6 -> {
                    result += " шестьсот"
                    counter--
                }

                7 -> {
                    result += " семьсот"
                    counter--
                }

                8 -> {
                    result += " восемьсот"
                    counter--
                }

                9 -> {
                    result += " девятьсот"
                    counter--
                }

                else -> {
                    counter--
                }

            }

            4 -> when (n % 10000 / 1000) {
                1 -> {
                    result += " тысяча"
                    counter--
                }

                2 -> {
                    result += " две тысячи"
                    counter--
                }

                3 -> {
                    result += " три тысячи"
                    counter--
                }

                4 -> {
                    result += " четыре тысячи"
                    counter--
                }

                5 -> {
                    result += " пять тысяч"
                    counter--
                }

                6 -> {
                    result += " шесть тысяч"
                    counter--
                }

                7 -> {
                    result += " семь тысяч"
                    counter--
                }

                8 -> {
                    result += " восемь тысяч"
                    counter--
                }

                9 -> {
                    result += " девять тысяч"
                    counter--
                }

                else -> {
                    counter--
                }

            }

            5 -> when (n % 100000 / 10000) {
                0 -> {
                    if (n % 10000 / 1000 == 0) {
                        result += " тысяч"
                        counter -= 2
                        continue
                    }
                    counter--
                }

                1 -> when (n % 10000 / 1000) {
                    0 -> {
                        result += " десять тысяч"
                        counter -= 2
                    }

                    1 -> {
                        result += " одиннадцать тысяч"
                        counter -= 2
                    }

                    2 -> {
                        result += " двенадцать тысяч"
                        counter -= 2
                    }

                    3 -> {
                        result += " тринадцать тысяч"
                        counter -= 2
                    }

                    4 -> {
                        result += " четырнадцать тысяч"
                        counter -= 2
                    }

                    5 -> {
                        result += " пятнадцать тысяч"
                        counter -= 2
                    }

                    6 -> {
                        result += " шестнадцать тысяч"
                        counter -= 2
                    }

                    7 -> {
                        result += " семнадцать тысяч"
                        counter -= 2
                    }

                    8 -> {
                        result += " восемнадцать тысяч"
                        counter -= 2
                    }

                    9 -> {
                        result += " девятнадцать тысяч"
                        counter -= 2
                    }
                }

                2 -> when (n % 10000 / 1000) {
                    1 -> {
                        result += " двадцать одна"
                        counter--
                    }

                    else -> {
                        result += " двадцать"
                        counter--
                    }
                }

                3 -> when (n % 10000 / 1000) {
                    1 -> {
                        result += " тридцать одна"
                        counter--
                    }

                    else -> {
                        result += " тридцать"
                        counter--
                    }
                }

                4 -> when (n % 10000 / 1000) {
                    1 -> {
                        result += " сорок одна"
                        counter--
                    }

                    else -> {
                        result += " сорок"
                        counter--
                    }
                }

                5 -> when (n % 10000 / 1000) {
                    1 -> {
                        result += " пятьдесят одна"
                        counter--
                    }

                    else -> {
                        result += " пятьдесят"
                        counter--
                    }
                }

                6 -> when (n % 10000 / 1000) {
                    1 -> {
                        result += " шестьдесят одна"
                        counter--
                    }

                    else -> {
                        result += " шестьдесят"
                        counter--
                    }
                }

                7 -> when (n % 10000 / 1000) {
                    1 -> {
                        result += " семьдесят одна"
                        counter--
                    }

                    else -> {
                        result += " семьдесят"
                        counter--
                    }
                }

                8 -> when (n % 10000 / 1000) {
                    1 -> {
                        result += " восемьдесят одна"
                        counter--
                    }

                    else -> {
                        result += " восемьдесят"
                        counter--
                    }
                }

                9 -> when (n % 10000 / 1000) {
                    1 -> {
                        result += " девяносто одна"
                        counter--
                    }

                    else -> {
                        result += " девяносто"
                        counter--
                    }
                }
            }

            6 -> when (n % 1000000 / 100000) {
                1 -> {
                    result += "сто"
                    counter--
                }

                2 -> {
                    result += "двести"
                    counter--
                }

                3 -> {
                    result += "триста"
                    counter--
                }

                4 -> {
                    result += "четыреста"
                    counter--
                }

                5 -> {
                    result += "пятьсот"
                    counter--
                }

                6 -> {
                    result += "шестьсот"
                    counter--
                }

                7 -> {
                    result += "семьсот"
                    counter--
                }

                8 -> {
                    result += "восемьсот"
                    counter--
                }

                9 -> {
                    result += "девятьсот"
                    counter--
                }

                else -> {
                    counter--
                }
            }
        }
    }
    return checkString(result)
}

fun checkString(s: String): String {
    var newString: String = ""

    for (i in s.indices) {
        if (i == 0 && s[0] == ' ') continue
        if (i == s.length - 1 && s[s.length - 1] == ' ') continue
        newString += s[i]
    }

    return newString
}

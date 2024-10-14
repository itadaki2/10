import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var prodolzhat = true // для продолжения работы программы

    while (prodolzhat) {
        // выводим выбор задания
        println("выберите задание: ")
        println("1 числа от n до 1")
        println("2 пирамида")
        println("3 шифр цезаря")
        println("4 fizzbuzz")
        println("5 выйти")

        val vybor = scanner.nextInt()

        // выполняем задание в зависимости от выбора
        when (vybor) {
            1 -> {
                println("введите число n")
                val chislo1 = scanner.nextInt()
                println(printNumber(chislo1)) // выводим список от chislo1 до 1
            }
            2 -> {
                println("введите количество уровней пирамиды")
                val uroven = scanner.nextInt()
                Pyramid(uroven) // выводим пирамиду
            }
            3 -> {
                println("введите строку")
                val stroka = scanner.next()
                println("введите сдвиг")
                val sdvig = scanner.nextInt()
                println(cezar(stroka, sdvig)) // выводим шифрованную строку
            }
            4 -> {
                println("введите число n для fizzbuzz")
                val chislo1 = scanner.nextInt()
                println(fizzBuzz(chislo1)) // выводим список fizzbuzz
            }
            5 -> {
                println("выход из программы")
                prodolzhat = false //  чтобы выйти из цикла
            }
            else -> println("неверное задание")
        }

        if (prodolzhat) {
            println("хотите выбрать задание еще раз? (да/нет)")
            val otvet = scanner.next()
            prodolzhat = otvet.lowercase() == "да" // выбор заново если да
        }
    }
}

// функция для чисел от n до 1
fun printNumber(chislo1: Int): List<Int> {
    return (chislo1 downTo 1).toList() // возвращаем список от chislo1 до 1
}

// функция для пирамиды
fun Pyramid(uroven: Int) {
    for (i in 1..uroven) {
        val probely = " ".repeat(uroven - i) // создаем пробелы слева
        val simvoly = "#".repeat(2 * i - 1) // создаем символы #
        println(probely + simvoly + probely) // выводим строку с символами
    }
}

// функция для цезаря
fun cezar(stroka: String, sdvig: Int): String {
    return stroka.map { char ->
        if (char.isLetter()) {
            val granica = if (char.isUpperCase()) 'A' else 'a'
            ((char - granica + sdvig) % 26 + granica.code).toChar() // сдвигаем букву
        } else {
            char // возвращаем символ без изменений если это не буква
        }
    }.joinToString("")
}

// функция fizzbuzz
fun fizzBuzz(chislo1: Int): List<String> {
    val result = mutableListOf<String>()
    for (i in 1..chislo1) {
        when {
            i % 3 == 0 && i % 5 == 0 -> result.add("визллбизлл")
            i % 3 == 0 -> result.add("физллл")
            i % 5 == 0 -> result.add("бизлллл")
            else -> result.add(i.toString())
        }
    }
    return result // список
}

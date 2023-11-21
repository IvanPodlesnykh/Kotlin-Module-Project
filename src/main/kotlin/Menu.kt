import java.lang.Exception
import java.util.Scanner

abstract class Menu(private val list: ArrayList<*>?){

    fun menu(actionName: String) {
        val scanner = Scanner(System.`in`)
        var command: Int

        while (true) {
            printMenu(actionName)

            while (true) {
                try {
                    command = scanner.nextInt()
                } catch (e: Exception) {
                    println("Некорректная комманда. Введите корректную комманду (целое число)")
                    scanner.next()
                    printMenu(actionName)
                    continue
                }
                if (list != null && command > list.size + 1 || list == null && command >= 2) {
                    println("Некорректная комманда. Введите корректную комманду (целое число)")
                    printMenu(actionName)
                    continue
                }
                break
            }

            when {
                command == 0 -> break
                command == 1 -> action()
                command >= 2  -> onItemSelect(command - 2)
            }
        }

    }

    fun getText(onStartMessage: String, onEmptyInputMessage: String): String {
        val scanner = Scanner(System.`in`)
        println(onStartMessage)
        var text: String
        while (true) {
            text = scanner.nextLine()
            if (text != "") break
            println(onEmptyInputMessage)
        }
        return text
    }

    private fun printMenu(actionName: String) {
        println("0. Выход")
        println("1. $actionName")
        if(list != null) {
            var counter = 2
            for (item in list) {
                println("$counter. $item")
                counter++
            }
        }
    }

    abstract fun action()

    abstract fun onItemSelect(index: Int)
}
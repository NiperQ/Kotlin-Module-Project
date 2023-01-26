import java.util.*

class Menu {
   fun menuPrinter(menu: MutableList<String>) {
        for (i in menu) {
            println(i)
        }
   }
  fun inputHandler(): Int {
      var input: Int
      while (true) {
          try {
              input = Scanner(System.`in`).nextInt()
              break
          } catch (e: InputMismatchException) {
              println("Введите цифру из пункта меню")
              continue
          }
    }
      return input
  }
}
import java.util.*

class ArchivesMenu {
    var archives = mutableListOf<Archive>()
    val archivesMenu = mutableListOf("Список архивов:", "0. Создать архив", "1. Выход из программы")
    val menu = Menu()

    fun start() {
        var input: Int
        while (true) {
            menu.menuPrinter(archivesMenu)
            input = menu.inputHandler()
            when (input) {
                0 -> createArchive()
                1 -> break
                in (archives.indices.first + 2..archives.indices.endInclusive + 2) -> inputHandler(input)
                else -> {
                    println("Введите цифру, среди тех что отображены в меню")
                    continue
                }
            }
        }
    }

     private fun inputHandler(input: Int) {
        val notesMenu = NotesMenu()
        notesMenu.start(archives[input - 2])
    }

    fun createArchive() {
        println("Введите название архива: ")
        val name = Scanner(System.`in`).nextLine()
        archives.add(Archive(name, arrayListOf()))
        archivesMenu.add("${archivesMenu.size - 1}. $name")
    }
}
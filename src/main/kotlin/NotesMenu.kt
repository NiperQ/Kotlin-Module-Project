import java.util.*

class NotesMenu {
    val notesMenu = mutableListOf("Список заметок:", "0. Создать заметку", "1. Назад")
    val menu = Menu()
    fun start(archive: Archive) {
        if (archive.notes.isNotEmpty()) {
            for (i in archive.notes.indices) {
                notesMenu.add("${i + 2}. ${archive.notes[i].name}")
            }
        }
        var input: Int
        while (true) {
            menu.menuPrinter(notesMenu)
            input = menu.inputHandler()
            when (input) {
                0 -> createNote(archive)
                1 -> break
                in (archive.notes.indices.first + 2..archive.notes.indices.last + 2) -> inputHandler(input, archive)
                else -> {
                    println("Введите цифру, среди тех что отображены в меню")
                    continue
                }
            }
        }
    }

    private fun inputHandler(input: Int, archive: Archive) {
        val noteMenu = NoteMenu()
        noteMenu.start(archive.notes[input - 2])


    }

    fun createNote(archive: Archive) {
        println("Введите название заметки: ")
        val name = Scanner(System.`in`).nextLine()
        println("Введите текст заметки: ")
        val text = Scanner(System.`in`).nextLine()
        archive.notes.add(Note(name, text))
        notesMenu.add("${notesMenu.size - 1}. $name")
    }
}
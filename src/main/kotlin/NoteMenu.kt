class NoteMenu {
    val menu = Menu()
    fun start(note: Note) {
        val noteMenu = mutableListOf("Название заметки: ${note.name}", "Текст заметки", note.text, "1. Назад")
        var input: Int
        while (true) {
            menu.menuPrinter(noteMenu)
            input = menu.inputHandler()
            when (input) {
                1 -> break
                else -> {
                    println("Введите 1, чтобы вернуться назад")
                    continue
                }
            }
        }
    }
}
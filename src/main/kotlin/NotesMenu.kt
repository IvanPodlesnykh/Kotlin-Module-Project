class NotesMenu(private val listOfNotes: ArrayList<Note>): Menu(listOfNotes) {

    override fun action() {
        val name = getText("Введите имя заметки", "Введите непустое имя заметки")
        val note = getText("Введите текст заметки", "Введите непустой текст заметки")
        listOfNotes.add(Note(name, note))
    }

    override fun onItemSelect(index: Int) {
        val note = NoteScreen(listOfNotes[index])
        note.menu("Показать заметку")
    }

}
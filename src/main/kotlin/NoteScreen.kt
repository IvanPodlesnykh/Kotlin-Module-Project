class NoteScreen(private val note: Note): Menu(null) {
    override fun action() {
        note.showNote()
    }

    override fun onItemSelect(index: Int) {
    }

}
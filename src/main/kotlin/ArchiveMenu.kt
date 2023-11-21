class ArchiveMenu(private val listOfArchives: ArrayList<Archive>): Menu(listOfArchives) {

    override fun action() {
        val name = getText("Введите имя архива", "Введите непустое имя архива")
        listOfArchives.add(Archive(name, ArrayList()))
    }

    override fun onItemSelect(index: Int) {
        val notesMenu = NotesMenu(listOfArchives[index].notes)
        notesMenu.menu("Новая заметка")
    }

}

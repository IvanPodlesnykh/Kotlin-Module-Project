data class Note(val name: String, val content: String) {
    fun showNote() {
        println(name)
        println("\"$content\"")
        println()
    }

    override fun toString(): String {
        return name
    }
}
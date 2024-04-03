package web.dam

data class DamTime(val dateTime: String) {
    companion object {
        fun from(text: String): DamTime? {
            return DamTime(text)
        }
    }

}

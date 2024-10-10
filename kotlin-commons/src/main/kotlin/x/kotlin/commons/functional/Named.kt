package x.kotlin.commons.functional

interface Named {
    fun name(): String
    fun name(name: String)
}

fun Any?.name(): String {
    val named = this as? Named
    return named?.name() ?: ""
}

inline fun <T> T.name(name: String): T {
    val named = this as? Named
    named?.name(name)
    return this
}
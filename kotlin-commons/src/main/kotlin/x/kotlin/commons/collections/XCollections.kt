package x.kotlin.commons.collections

object XCollections {

    fun <T> MutableCollection<T>.removeIfContains(item: T?) {
        if (item != null && contains(item)) {
            remove(item)
        }
    }
}
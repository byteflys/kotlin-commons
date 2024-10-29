package x.kotlin.commons.serialize

object JSON {

    private val serializer: Serializer = GsonSerializer

    fun Any.toJson(): String {
        return serializer.toJson(this)
    }

    fun <T> String.fromJson(clazz: Class<T>): T {
        return serializer.fromJson(this, clazz)
    }

    fun Any?.toJsonOrNull(placeholder: String? = null): String? {
        if (this == null)
            return placeholder
        if (this is String)
            return this
        if (this is Number)
            return this.toString()
        return toJson()
    }

    fun <T> String?.fromJsonOrNull(clazz: Class<T>, placeholder: T? = null): T? {
        if (this == null)
            return placeholder
        return fromJson(clazz)
    }
}
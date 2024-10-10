package x.kotlin.commons.preference

interface Preference {

    fun <T> put(key: String, obj: T): Preference

    fun <T> get(key: String, clazz: Class<T>): T
}
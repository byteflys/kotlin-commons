package x.kotlin.commons.serialize

import com.google.gson.Gson

object GsonSerializer : Serializer {

    private val gson = Gson()

    fun gson() = Gson()

    override fun <T> fromJson(json: String, clazz: Class<T>): T {
        return gson.fromJson(json, clazz)
    }

    override fun toJson(obj: Any): String {
        return gson.toJson(obj)
    }
}
package io.github.hellogoogle2000.kotlin.commons.serialize

interface Serializer {

    fun <T> fromJson(json: String, clazz: Class<T>): T

    fun toJson(obj: Any): String
}
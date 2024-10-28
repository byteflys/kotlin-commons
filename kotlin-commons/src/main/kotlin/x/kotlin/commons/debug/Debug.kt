package x.kotlin.commons.debug

import x.kotlin.commons.serialize.JSON.toJsonOrNull

object Debug {

    fun printWithThreadInfo(obj: Any?) {
        val message = obj.toJsonOrNull("")
        val tid = Thread.currentThread().id
        val name = Thread.currentThread().name
        println("$tid $name $message")
    }
}
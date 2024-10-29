package x.kotlin.commons.debug

import x.kotlin.commons.serialize.JSON.toJsonOrNull

object XConsole {

    fun printWithThreadInfo(obj: Any?) {
        val message = obj.toJsonOrNull("")
        val tid = Thread.currentThread().id
        val name = Thread.currentThread().name
        println("$message <tid=$tid $name>")
    }
}
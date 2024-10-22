package x.kotlin.commons.string

import java.util.UUID

object UUID {

    fun long() = UUID.randomUUID().toString()

    fun short() = long().replace("-".toRegex(), "")
}
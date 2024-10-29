package x.kotlin.commons.string

import kotlin.random.Random

object RandomID {

    private val chars = listOf("a", "b", "c", "d", "e", "2", "3", "4", "5", "6", "7", "8", "9")

    fun random(bits: Int = 6): String {
        val id = StringBuilder()
        for (i in 0 until bits) {
            val index = Random.nextInt(999999) % chars.size
            id.append(chars[index])
        }
        return id.toString()
    }
}
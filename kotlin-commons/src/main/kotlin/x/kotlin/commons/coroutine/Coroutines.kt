package x.kotlin.commons.coroutine

import kotlin.coroutines.Continuation
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.startCoroutine

object Coroutines {

    fun <T> createCoroutine(block: suspend () -> T): Continuation<Unit> {
        val completion = x.kotlin.commons.coroutine.EmptyContinuation<T>()
        val continuation = block.createCoroutine(completion)
        return continuation
    }

    fun <T> startCoroutine(block: suspend () -> T) {
        val completion = x.kotlin.commons.coroutine.EmptyContinuation<T>()
        block.startCoroutine(completion)
    }
}
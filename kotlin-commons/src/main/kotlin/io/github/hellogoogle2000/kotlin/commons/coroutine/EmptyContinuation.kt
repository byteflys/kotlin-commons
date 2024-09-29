package io.github.hellogoogle2000.kotlin.commons.coroutine

import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext

open class EmptyContinuation<T> : Continuation<T> {

    override val context = EmptyCoroutineContext

    override fun resumeWith(result: Result<T>) {}
}
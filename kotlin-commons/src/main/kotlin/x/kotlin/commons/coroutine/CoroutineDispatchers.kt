package x.kotlin.commons.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

object CoroutineDispatchers {

    private val currentExecutor = Executor { runnable -> runnable.run() }

    private val newExecutor = Executors.newCachedThreadPool()

    private val dataExecutor = Executors.newSingleThreadExecutor()

    private val ioExecutor = Executors.newScheduledThreadPool(5)

    private val networkExecutor = Executors.newScheduledThreadPool(5)

    fun current() = Dispatcher(currentExecutor)

    fun new() = Dispatcher(newExecutor)

    fun data() = Dispatcher(dataExecutor)

    fun io() = Dispatcher(ioExecutor)

    fun network() = Dispatcher(networkExecutor)

    fun sequence() = Dispatcher(Executors.newSingleThreadExecutor())
}

open class Dispatcher(
    val executor: Executor
) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        executor.execute(block)
    }
}
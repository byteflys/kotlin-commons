package x.kotlin.commons.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.Runnable
import x.kotlin.commons.thread.ExecutorBuilder.createCurrentThreadExecutor
import x.kotlin.commons.thread.ExecutorBuilder.createFixedThreadExecutor
import x.kotlin.commons.thread.ExecutorBuilder.createNewThreadExecutor
import x.kotlin.commons.thread.ExecutorBuilder.createSharedThreadExecutor
import x.kotlin.commons.thread.ExecutorBuilder.createSingleThreadExecutor
import x.kotlin.commons.thread.ExecutorBuilder.disposeIfAutoDisposable
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import kotlin.coroutines.CoroutineContext

object XDispatchers {

    private val currentExecutor = createCurrentThreadExecutor()

    private val sharedExecutor = createSharedThreadExecutor("XDispatchers-share")

    private val ioExecutor = createFixedThreadExecutor("XDispatchers-io")

    private val dataExecutor = createSingleThreadExecutor("XDispatchers-data")

    private val networkExecutor = createFixedThreadExecutor("XDispatchers-network")

    fun current() = Dispatcher(currentExecutor)

    fun new() = Dispatcher(createNewThreadExecutor("XDispatchers-new"))

    fun share() = Dispatcher(sharedExecutor)

    fun io() = Dispatcher(ioExecutor)

    fun data() = Dispatcher(dataExecutor)

    fun network() = Dispatcher(networkExecutor)

    fun sequence() = Dispatcher(createSingleThreadExecutor("XDispatchers-sequence"))
}

open class Dispatcher(
    val executor: Executor
) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        context[Job]?.invokeOnCompletion {
            (executor as? ExecutorService)?.disposeIfAutoDisposable()
        }
        executor.execute(block)
    }
}
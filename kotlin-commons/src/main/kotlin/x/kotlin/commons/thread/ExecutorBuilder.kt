package x.kotlin.commons.thread

import okhttp3.internal.threadFactory
import x.kotlin.commons.collections.XCollections.removeIfContains
import x.kotlin.commons.string.RandomID
import x.kotlin.commons.value.KotlinCommonsValues.defaultThreadName
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory

object ExecutorBuilder {

    val threadGroup = ThreadGroup("ExecutorBuilder")

    val disposables = mutableSetOf<ExecutorService>()

    fun createThreadFactory(
        name: String = defaultThreadName,
        daemon: Boolean = true,
        threadGroup: ThreadGroup = ExecutorBuilder.threadGroup
    ) = ThreadFactory { runnable ->
        val t = Thread(threadGroup, runnable)
        t.name = name + "-" + RandomID.random()
        t.isDaemon = daemon
        return@ThreadFactory t
    }

    fun createSingleThreadExecutor(
        name: String = defaultThreadName,
        daemon: Boolean = true
    ): ExecutorService {
        val threadFactory = createThreadFactory(name, daemon)
        return Executors.newSingleThreadScheduledExecutor(threadFactory)
    }

    fun createFixedThreadExecutor(
        name: String = defaultThreadName,
        daemon: Boolean = true,
        threadCount: Int = 5
    ): ExecutorService {
        val threadFactory = createThreadFactory(name, daemon)
        return Executors.newFixedThreadPool(threadCount, threadFactory)
    }

    fun createSharedThreadExecutor(
        name: String = defaultThreadName,
        daemon: Boolean = true
    ): ExecutorService {
        val threadFactory = createThreadFactory(name, daemon)
        return Executors.newCachedThreadPool(threadFactory)
    }

    fun createCurrentThreadExecutor() = Executor { runnable -> runnable.run() }

    fun createNewThreadExecutor(
        name: String = defaultThreadName,
        daemon: Boolean = true
    ) = Executor { runnable ->
        createThreadFactory(name, daemon).newThread(runnable).start()
    }

    fun <T : ExecutorService> T.setAutoDisposable(): T {
        disposables.add(this)
        return this
    }

    fun ExecutorService.isAutoDisposable() = disposables.contains(this)

    fun ExecutorService.dispose() {
        disposables.removeIfContains(this)
        shutdown()
    }

    fun ExecutorService.disposeIfAutoDisposable() {
        if (!isAutoDisposable()) return
        dispose()
    }
}
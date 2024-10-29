package x.kotlin.commons

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import x.kotlin.commons.coroutine.XDispatchers
import x.kotlin.commons.debug.XConsole.printWithThreadInfo

internal typealias ApacheFileUtils = org.apache.commons.io.FileUtils
internal typealias ApacheFileNameUtils = org.apache.commons.io.FilenameUtils

object KotlinCommons {

}

fun main() {
    GlobalScope.launch(XDispatchers.new()) {
        printWithThreadInfo("xxx")
    }
    GlobalScope.launch(XDispatchers.io()) {
        printWithThreadInfo("xxx")
    }
    GlobalScope.launch(XDispatchers.io()) {
        printWithThreadInfo("xxx")
    }
    GlobalScope.launch(XDispatchers.current()) {
        printWithThreadInfo("xxx")
    }
    Thread.sleep(4000)
}
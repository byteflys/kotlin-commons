package x.kotlin.commons.io

import org.apache.commons.io.IOUtils
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

object IO {

    fun String.asFile() = File(this)

    fun File.asInputStream() = FileInputStream(this)

    fun File.asOutputStream() = FileOutputStream(this)

    fun InputStream.copyTo(dst: OutputStream) = IOUtils.copy(this, dst)

    fun copyTo(src: String, dst: String) {
        val input = src.asFile().asInputStream()
        val output = dst.asFile().asOutputStream()
        input.copyTo(output)
    }

    fun copyTo(src: File, dst: File) {
        val input = src.asInputStream()
        val output = dst.asOutputStream()
        input.copyTo(output)
    }
}
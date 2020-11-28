package cn.isif.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    /**
     * 初识协程
     *
     * GlobalScope 是一种CoroutineScope
     * launch能构造协程作用域
     */
    GlobalScope.launch {
        Thread.sleep(5_00)
        println("coroutine")
    }
    println("hallo")
    Thread.sleep(1_000)
    println("end")
}
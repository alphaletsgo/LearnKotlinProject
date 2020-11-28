package cn.isif.kotlin.demo

import java.io.File

/**
 * 功能：统计文件中除空格之外字符的个数
 * 说明：本例使用工程下面的build.gradle文件为例
 */
fun main() {
    File("./build.gradle").readText()//读取文本类容
        .toCharArray()//将文本转换为数组
        .filterNot { it.isWhitespace() }//过滤空白字符
        .groupBy { it }//分组
        .map { it.key to it.value.size }
        .let { println(it) }
}
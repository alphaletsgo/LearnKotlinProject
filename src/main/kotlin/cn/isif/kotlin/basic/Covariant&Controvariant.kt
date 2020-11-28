package cn.isif.kotlin.basic

import java.lang.IllegalArgumentException

//泛型的协变与逆变
/**
 * 协变，java中称为泛型的上限：
 *  Collection<String>是Collection<? extends Object>的子类型。且，这样只能读不能写
 * 逆变，java中称为泛型的下限：
 *  Collection<? supper String>：表示能存放String，以及String父类类型。且，这个只能写入，不能读取
 *
 * kotlin使用out和in关键字来实现协变和逆变
 *
 * 一般的，out对应着输出，意味生产者。in表示输入，意味着消费。
 */

fun main() {
    var dest = arrayOfNulls<Number>(5)
    val src = arrayOf<Double>(1.1, 1.2, 1.3, 1.4, 1.5)
    copyIn(dest, src)
    dest.forEach {
        println(it)
    }
}

//使用in
fun <T> copyIn(dest: Array<in T>, src: Array<T>) {
    if (src.size > dest.size) {
        throw IllegalArgumentException()
    } else {
        src.forEachIndexed { index, value ->
            dest[index] = value
        }
    }
}

//使用out
fun <E> copyOut(dest: Array<E>, src: Array<out E>) {
    if (dest.size < src.size) {
        throw IllegalArgumentException()
    } else {
        src.forEachIndexed { index, e ->
            dest[index] = e
        }
    }
}
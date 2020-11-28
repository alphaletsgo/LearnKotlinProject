package cn.isif.kotlin.basic


fun main() {
    //lambda表达式
    val sum1: (x: Int, y: Int) -> Int = { x: Int, y: Int ->
        x + y
    }
    //或
    val sum2 = { x: Int, y: Int ->
        x + y
    }
    //或
    val sum3: (x: Int, y: Int) -> Int = { x, y ->
        x + y
    }

//    listOf(1, 2, 3, 4).forEach { println(it) }
    sum(1)(2)(3).let { println(it) }

    val a = arrayOf(1,2,3)
    val b = arrayOf(1,2,3,4)
    a.corresponds(b){
        x,y -> x==y
    }.let { println(it) }
}

fun foo(num: Int) = {
    println(num)
}

fun foo1(num: Int) {
    println(num)
}

fun sum(x: Int, y: Int, z: Int): Int {
    return x + y + z
}

fun sum(x: Int) = { y: Int ->
    { z: Int ->
        x + y + z
    }
}
fun <A,B>Array<A>.corresponds(that:Array<B>,p:(A,B) -> Boolean):Boolean{
    val i = this.iterator()
    val j = that.iterator()
    while (i.hasNext() && j.hasNext()){
        if (!p(i.next(),j.next())){
            return false
        }
    }
    return !i.hasNext() && !j.hasNext()
}
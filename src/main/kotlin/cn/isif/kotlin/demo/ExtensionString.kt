package cn.isif.kotlin.demo

/**
 * 扩展String操作符 实现String的减乘除 运算
 */

//-
operator fun String.minus(right:Any):String{
    return this.replaceFirst(right.toString(), "")
}
//*
operator fun String.times(right:Int):String{
    return (1..right).joinToString("") { this }
}

operator fun String.div(right: Any?):Int{
    var str = right.toString()
    return this.windowed(str.length,1){
        it == right
    }.count{it}

}

fun main() {
    var str = "hello kotlin"
    println(str - "hello")
    println(str*3)
    println("*"*10)
    println("***"/"*")
}
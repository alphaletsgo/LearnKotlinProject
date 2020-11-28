package cn.isif.kotlin.demo

import java.lang.Exception

/**
 * 计算机 四则运算
 * example：3 * 4
 */

fun main(vararg str:String) {
    if (str.size<3){
        showHelp()
    }
    //定义操作符map
    val operations = mapOf(
        "+" to ::plus,
        "-" to ::sub,
        "*" to ::times,
        "/" to ::divide
    )
    //根据输入获取相应的操作函数
    var op = operations[str[1]] ?: return showHelp() //kotlin特性 为空判断
    try {
        println("Input:${str.joinToString(" ")}") //joinToString 默认的分隔符是',' 可以在构造函数中进行指定
        println("Output:${op(str[0].toInt(),str[2].toInt())}")
    }catch (e:Exception){
        showHelp()
    }

}

fun showHelp(){
    println("""
        
        Error Input!!!
        your input format eg:
            input: 3 * 5
            output: 15
    """.trimIndent())
}

fun plus(num1:Int,num2:Int):Int{
    return num1 + num2
}
fun sub(num1:Int,num2:Int):Int{
    return num1 - num2
}
fun times(num1:Int,num2:Int):Int{
    return num1 * num2
}
fun divide(num1:Int,num2:Int):Int{
    return num1 / num2
}
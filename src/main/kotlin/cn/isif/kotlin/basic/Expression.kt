package cn.isif.kotlin.basic

fun main() {
    //?:语法：用来给为空类型赋值
    var arg: Int? = null //一般情况下我们不能直接为变量赋值null，但是我们可以将变量声明为可空类型，使用"?"
    println(arg)
    println(arg ?: 100)
    arg = 1
    println(arg)
    var fv = schedule(Day.FRI)
    println(fv)
//    for (i in 1..10){
    var str = "abc".."xyz"
    println(str)
    println("kot" in str)
//    for (i in 1..10 step 2){
    for (i in 1 until 10 step 2){
        println(i)
    }
    var p = Person()
    p callMe "Bane"

    for (i in "hello"){
        println(i)
    }
    println(1===2)
}

fun schedule(day: Day) = when (day) {
    Day.SAT -> basketball()
    Day.SUN -> fishing()
    Day.FRI -> appointment()
    else -> nothing()
}

fun basketball() {
    println("play basketball")
}

fun fishing() {
    println("go fish")
}

fun appointment():String {
    println("appointment")
    return "appointment"
}

fun nothing() {
    println("nothing to do")
}

//枚举类
//enum class Day{
//    MON,
//    TUE,
//    WEN,
//    THU,
//    FRI,
//    SAT,
//    SUN
//}
enum class Day(val day: Int) {
    MON(1),
    TUE(2),
    WEN(3),
    THU(4),
    FRI(5),
    SAT(6),
    SUN(7);//如果还有其他属性或方法的定义，这里必须加上分号

    fun getDayNumber(): Int {
        return day
    }
}
//中缀表达式
class Person{
    infix fun callMe(name:String){
        println(name)
    }
}

package cn.isif.kotlin.basic

class Student(val name: String, val age: Int, val sex: String, val score: Int)

fun Student.printSelf() {
    println("$name,$age,$sex,$score")
}

fun main() {
    //构造集合
    val students = listOf<Student>(
        Student("pit", 23, "m", 93),
        Student("mac", 22, "f", 89),
        Student("jon", 21, "m", 96),
        Student("sam", 22, "f", 73),
        Student("vil", 21, "m", 83)
    )
    //map
    val stu = students.map {
        it.score + 1
        it
    }
    stu.forEach { it.printSelf() }
    //reduce
    val numberList = listOf<Int>(1, 2, 3, 4)
    val total = numberList.reduce { acc, i ->
        acc + i
    }
    println(total)
    //groupBy
    val gSex = students.groupBy { it.sex }  //分组
    gSex.keys.forEach { key ->
        gSex[key]?.forEach {
            it.printSelf()
        }
    }
    //集合嵌套处理
    val lists = listOf(
        listOf(1, 2, 3, 4),
        listOf(5, 6, 7, 8)
    )
    println(lists.flatten())    //合并

    lists.map {
        println(it + 10)
    }

    //flatMap = flatten + map
    val num = lists.flatMap {
        it.asIterable()
    }
    println(num)

    //可变集合和只读集合
    var orList = listOf(1, 2, 3, 4)
//    orList[1] = 3  error:只读集合不能修改集合里面的元素
    var mtList = mutableListOf(1, 2, 3, 4)
    mtList[0] = 3   //可变集合里的元素可以进行修改

    /**
     * 惰性集合:针对集合数量巨大的操作
     * 惰性计算
     *  1、不会产生中间变量，优化性能
     *  2、构造无限序列
     * 惰性计算的操作分为两部分，其一是中间操作，其二是终端操作；中间操作不会立即执行，只有执行的终端操作才会去执行
     *
     */
    //一个简单的惰性集合运用
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val result = numbers.asSequence().filter {
        it % 2 == 0
    }.map { it * 10 }.toList()
    println(result)
    //构造一个无限序列
    val naturalNumList = generateSequence(0) { it + 1 }
    println(naturalNumList.takeWhile { it < 10 }.toList())



}
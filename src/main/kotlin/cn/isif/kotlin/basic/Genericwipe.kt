package cn.isif.kotlin.basic


//泛型擦除

/**
 * 获取泛型的类型
 * 泛型的信息并没有完全被擦除，类型信息会被存放在class的常量池中
 */
fun main() {
    val list = arrayListOf<String>()
    println(list.javaClass.genericSuperclass) //无法获取到泛型的类型
    //匿名内部类获取泛型类型
    val list1 = object : ArrayList<String>() {}
    println(list1.javaClass.genericSuperclass)
    println(getGenericType<String>())
}

//使用内联函数获取泛型类型
inline fun <reified T> getGenericType(): Class<T> {
    return T::class.java
}



package cn.isif.kotlin.oop


fun main() {
    val b = Bird(15.0, 2, "yellow")
    b.printSex()
}

class Bird(weight: Double, age: Int, color: String) {
    val weight: Double
    val age: Int
    val color: String
//    val sex: String
//    val sex:String by lazy { if (color=="blue") "male" else "female" }

    init {
        this.weight = weight
        println("The bird's weight is ${this.weight}kg")
        this.age = age
        println("The bird's age is ${this.age}")
    }

    init {
        this.color = color
        println("The bird's color is ${this.color}")
    }

//    init {
//        this.sex = if (this.color == "blue") "male" else "female"
//        println("The bird's sex is ${this.sex}")
//    }
    lateinit var sex:String
    fun printSex(){
        this.sex = if (this.color == "blue") "male" else "female"
        println("The bird's sex is ${this.sex}")
    }

}
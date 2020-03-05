package com.donfyy.kotlin

class Person constructor(val name: String) {
    val firstProperty: String = "first property".also(::println)

    init {
        println("init block 1.")
    }

    val secondProperty: String = "second property".also(::println)

    init {
        println("init block 2.")
    }

    constructor(name: String, isMale: Boolean, birth: String) : this(name) {
        println("secondary constructor")
    }

    init {
        println("init block 3. $name")
    }
}

open class Base(val name: String) {
    init {
        println("Initializing Base")
    }

    open val size: Int = name.length.also { println("Initializing size in Base $it") }
}

class Derived(name: String, val lastName: String) : Base(name.capitalize().also { println("Argument for Base:$it") }) {
    init {
        println("Initialing Derived")
    }

    override val size: Int = (super.size + lastName.length).also { println("Initializing size in Derived :$it") }
}

open class Rectangle {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val boarderColor: String get() = "black"
}

interface Polygon {
    fun draw() {}
}

interface IA {

}

//一个类从它的直接超类继承自相同成员的多个实现，它必须覆盖这个成员并提供自己的实现
class FilledRectangle : Rectangle(), IA, Polygon {
    override fun draw() {
        super<Rectangle>.draw()
//        draw方法必须重写,必须是相同成员有多个实现。
    }
//    override fun draw() {
//        super.draw()
//
//        println("Filling the rectangle")
//    }

    val fillColor: String get() = boarderColor
}

class C {
    private fun fun1() = object {
        val x: String = "x"
    }

    fun fun2() = object {
        val x: String = "x"
    }

    fun fun3() {
//        java 的方法会明确地指出返回值地类型，因此没有返回匿名对象的私有函数的返回类型是匿名对象类型一说
        var x = fun1().x
//        fun2().x
    }


}
object Singletona {
//  对象声明是在第一次被访问时延迟初始化的

//    companion object Singletonb {
// 对象声明不能拥有伴生对象
//    }
}

class Companion {
    companion object {
//        伴生对象是在对应类被加载时延迟初始化的
    }
}

fun main() {
//    Person("donfyy", true, "20200101")

//    Derived("donfyy", "z")

    FilledRectangle().draw()
}
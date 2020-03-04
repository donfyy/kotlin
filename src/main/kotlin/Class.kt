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

fun main() {
//    Person("donfyy", true, "20200101")

    Derived("donfyy", "z")
}
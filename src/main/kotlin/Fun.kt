package com.donfyy.kotlin

fun main() {
    //    println(describe()) 若方法未提供参数的默认值，则掉用处不可以省略对应的实参
//    Error:(28, 22) Kotlin: No value passed for parameter 'obj'
//    fun1()//编译报错：Error:(6, 10) Kotlin: No value passed for parameter 'a'

    fun2()//no problem，此处省略了一个实参

//    fun3(1)//编译错误：No value passed for parameter 'b'


    fun4()
}

private fun fun4() {
    listOf(1, 2, 3).forEach {
        if (it == 3) return // ⾮局部直接返回到 foo() 的调⽤者
//        这种非局部的返回只支持传递给内联函数的lambda表达式
//        这不是坑人吗。。。卧槽
    }

    println("unreachable!")
}

fun fun1(a: Int) {

}

fun fun2(a: Int = 1) {

}

//第一个参数的默认值永远无法生效，调用者必须同时传入ab
fun fun3(a: Int = 0, b: Int) {

}

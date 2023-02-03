package com.xmzhou.programinginscala.chapter9

/**
 * scala 传名参数
 */
object ByNameFunction {

  /**
   * 传名参数
   */

  var assertionsEnabled = false

  /**
   * 这样写没什么问题，但是调用很别扭：myAssert(()=> 5 > 3)
   * 我们更愿意希望直接这样写：myAssert(5 > 3)
   * 因此，传名参数为此诞生。要让参数成为传名参数，需要一个 => 开头的申明类型
   * 把类型 ()=> Boolean 改为 => Boolean
   */
  def myAssert(predicate: () => Boolean): Unit =
    if (assertionsEnabled && !predicate())
      throw new AssertionError

  def byNameAssert(predicate: => Boolean): Unit =
    if (assertionsEnabled && !predicate)
      throw new AssertionError

  /**
   * 为什么不能使用boolean来作为其参数的类型申明
   */
  def boolAssert(predicate: Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError


  def main(args: Array[String]): Unit = {

    boolAssert(5 / 0 == 0) // ArithmeticException: / by zero
    //    byNameAssert(5 / 0 == 0) // 不报错

    // 由于boolAssert的参数类型为Boolean，在boolAssert(5>3)圆括号中的表达式会先于对boolAssert的调用被求值
    // 而 由 于 byNameAssert 的
    //predicate参数类型是=> Boolean，在byNameAssert(5 > 3)的圆括号
    //中的表达式在调用byNameAssert之前并不会被求值，而是会有一个函
    //数值被创建出来，这个函数值的apply方法将会对5 > 3求值，传入
    //byNameAssert的是这个函数值。

    // 因此，两种方式的区别在于如果断言被禁用，你将能够观察到
    //boolAssert的圆括号当中的表达式的副作用，而用byNameAssert则不
    //会。例如，如果断言被禁用，那么我们断言“
    //x / 0 == 0”的话，
    //boolAssert会抛异常


  }
}

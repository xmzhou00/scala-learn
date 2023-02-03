package com.xmzhou.programinginscala.chapter12

import scala.collection.mutable.ArrayBuffer

/**
 * 类和特质的区别在于类中的super调用是静态绑定的，而在
 * 特质中super是动态绑定的。
 */

/**
 * 作为可叠加的trait
 */
abstract class IntQueue {
  def get(): Int

  def put(x: Int)

}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  override def get(): Int = buf.remove(0)

  override def put(x: Int): Unit = {
    buf += x
  }
}

/**
 * Doubling 只能被混入同样继承子IntQueue的类中
 */
trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = {
    super.put(2 * x)
  }
}

trait Incrementing extends IntQueue{
  abstract override def put(x: Int): Unit = {
    super.put(x + 1)
  }
}

class MyQueue extends BasicIntQueue with Incrementing with Doubling
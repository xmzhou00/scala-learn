package com.xmzhou.programinginscala.chapter12

/**
 * scala trait
 */
trait Philosophical {
  def philosophize() = {
    println("I consume memory,therefore I am")
  }
}

/**
 * 使用 [[extends]]或 [[with]]关键字混入到类中
 */
class Frog extends Philosophical{
  override def toString: String = "green"
}

class Animal2

class Snake extends Animal2 with Philosophical{
  override def toString: String = "gray"

  override def philosophize(): Unit = println("snake")
}

object SnakeTest{
  def main(args: Array[String]): Unit = {
    val s:Philosophical = new Snake
    s.philosophize()

    val s1:Animal2 = new Snake
    println(s1)
  }
}
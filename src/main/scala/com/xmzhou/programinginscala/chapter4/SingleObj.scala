package com.xmzhou.programinginscala.chapter4

object SingleObj {

  private var sum = 0

  def incr: Unit = sum += 1

  def decr: Unit = sum -= 1

  def get: Int = sum
}

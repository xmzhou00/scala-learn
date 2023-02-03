package com.xmzhou.programinginscala.chapter4

//class Rational(n: Int, d: Int) { //编译报错
//  def add(b: Rational): Rational =
//    new Rational(n * b.d + b.n * d, d * b.d)
//}


class Rational(n: Int, d: Int) {
  val number = n
  val denom = d

  def add(b: Rational): Rational =
    new Rational(number * b.denom + b.number * denom, denom * b.denom)
}

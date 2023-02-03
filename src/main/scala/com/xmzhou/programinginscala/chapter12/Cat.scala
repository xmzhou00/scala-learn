package com.xmzhou.programinginscala.chapter12

/**
 * scala trait 线性化
 */
class Animal

trait Furry extends Animal

trait HasLegs extends Animal

trait FourLegged extends HasLegs

class Cat extends Animal with Furry with FourLegged

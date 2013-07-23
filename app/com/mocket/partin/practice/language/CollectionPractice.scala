package com.mocket.partin.practice.language

/**
 * Created with IntelliJ IDEA.
 * User: Masahiro
 * Date: 13/07/23
 * Time: 23:13
 *
 * This is Collection class which can contain only 3 elements.
 *
 */
class MyTriple[A](val first: A,
                            val second :A,
                            val third :A) extends Traversable[A]{

  def foreach[U](f: A => U) = {
    f(first)
    f(second)
    f(third)
  }

}


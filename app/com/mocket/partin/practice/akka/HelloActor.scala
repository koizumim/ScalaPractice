package com.mocket.partin.practice.akka

import akka.actor._

/**
 * Created with IntelliJ IDEA.
 * User: Masahiro
 * Date: 13/06/21
 * Time: 22:22
 * To change this template use File | Settings | File Templates.
 */
class HelloActor extends Actor {
  def receive = {
    case s: String => Unit
    case _ => Unit
  }


}

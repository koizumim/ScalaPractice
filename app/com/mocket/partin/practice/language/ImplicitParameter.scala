package com.mocket.partin.practice.language

/**
 * Created with IntelliJ IDEA.
 * User: Masahiro
 * Date: 13/06/26
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
class PreferredPrompt(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt) {
    println("Welcome, " + name + ". The system is ready.")
    println(prompt.preference)
  }
}

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master> ")
}
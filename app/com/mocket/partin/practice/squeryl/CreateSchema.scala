package com.mocket.partin.practice.squeryl

import org.squeryl.{Session, SessionFactory}
import org.squeryl.adapters.PostgreSqlAdapter
import org.squeryl.PrimitiveTypeMode._

/**
 * Created with IntelliJ IDEA.
 * User: Masahiro
 * Date: 13/06/22
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
object CreateSchema {
  def execute:Unit = {
    Class.forName("org.postgresql.Driver")
    val url = "jdbc:postgresql://localhost:5432/postgres"
    val username = "practice"
    val password = "practice"

    SessionFactory.concreteFactory = Some(() =>
      Session.create(
        java.sql.DriverManager.getConnection(url, username, password),
        new PostgreSqlAdapter
      ))

    transaction {
      Library.create
    }

  }
}

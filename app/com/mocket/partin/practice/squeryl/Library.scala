package com.mocket.partin.practice.squeryl

import java.sql.Timestamp
import java.util.Date
import org.squeryl.Schema
import org.squeryl.annotations.Column

/**
 * Created with IntelliJ IDEA.
 * User: Masahiro
 * Date: 13/06/22
 * Time: 20:12
 * To change this template use File | Settings | File Templates.
 */

class Author(val id:Long,
              val firstname: String,
              val lastName: String,
              val email: Option[String]) {
  def this() = this(0,"","",Some(""))
}

// fields can be mutable or immutable

class Book(val id: Long,
            var title: String,
            @Column("AUTHOR_ID")
            var authorId: Long,
            var coAuthorId: Option[Long]) {

  def this() = this(0,"",0,Some(0L))
}

class Borrowal(val id: Long,
                val bookId: Long,
                val borrowerAccountId: Long,
                val scheduledToReturnOn: Date,
                val returnedOn: Option[Timestamp],
                val numberOfPhonecallsForNonReturn: Int)

object Library extends Schema {

  val authors = table[Author]("AUTHORS")

  val books = table[Book]

  val borrowals = table[Borrowal]
}

package models

import anorm._
import anorm.SqlParser._
import java.util.Date
import play.api.db._
import play.api.Play.current

// Model
case class Movement(id: Long, concept: String, date: Date, amount: Long)

object Movement {

  // anorm parser for Task
  val movementParser = {
    long("id") ~ 
    str("concept") ~
    long("date") ~
    long("amount") map {
      case id~concept~date~amount => Movement(id, concept, new Date(date), amount)
    }
  }

  def all(): List[Movement] = DB.withConnection { implicit c =>
    SQL("select * from movement").as(movementParser *)
  }
  
}
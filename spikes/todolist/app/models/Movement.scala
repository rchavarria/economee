package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

// Model
case class Movement(id: Long, concept: String, amount: Long)

object Movement {

  // anorm parser for Task
  val movementParser = {
    get[Long]("id") ~ 
    get[String]("concept") ~
    get[Long]("amount") map {
      case id~concept~amount => Movement(id, concept, amount)
    }
  }

  def all(): List[Movement] = DB.withConnection { implicit c =>
    SQL("select * from movement").as(movementParser *)
  }
  
}
package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

// Model
case class Movement(id: Long, concept: String)

object Movement {

  // anorm parser for Task
  val movementParser = {
    get[Long]("id") ~ 
    get[String]("concept") map {
      case id~concept => Movement(id, concept)
    }
  }

  def all(): List[Movement] = DB.withConnection { implicit c =>
    SQL("select * from movement").as(movementParser *)
  }
  
}
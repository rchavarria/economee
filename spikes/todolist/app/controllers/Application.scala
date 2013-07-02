package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok("Welcome to my first Play app")
  }

  def tasks = TODO
  
  def newTask = TODO
  
  def deleteTask(id: Long) = TODO
    
}
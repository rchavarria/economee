package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
  	// redirect to the list of tasks
    Redirect(routes.Application.tasks)
  }

  def tasks = TODO
  
  def newTask = TODO
  
  def deleteTask(id: Long) = TODO
    
}
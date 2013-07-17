package controllers

import java.util._

import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._

import models._

object Application extends Controller {
  
  val r = new Random

  def index = Action {
  	// redirect to the list of tasks
    // Redirect(routes.Application.tasks)
    Redirect(routes.Application.movements)
  }

  def tasks = Action {
    Ok(views.html.index(Task.all(), taskForm))
  }
  
  def movements = Action {
    // creates a dummy movement
    Movement.create("oh my gosh!", new Date(), r.nextInt(100) * 1000)

  	Ok(views.html.movements(Movement.all()))
  }
  
  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Task.all(), errors)),
      label => {
        Task.create(label)
        Redirect(routes.Application.tasks)
      }
    )
  }
  
  def deleteTask(id: Long) = Action {
    Task.delete(id)
    Redirect(routes.Application.tasks)
  }
  
  // define a form for Task's
  val taskForm = Form(
    "label" -> nonEmptyText
  )
}
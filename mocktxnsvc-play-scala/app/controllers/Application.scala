package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Welcome to the PROS Transaction Service (Scala version)!"))
  }
  
}
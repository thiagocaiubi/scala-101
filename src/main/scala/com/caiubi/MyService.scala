package com.caiubi

import akka.actor.Actor
import spray.http.MediaTypes
import spray.routing.HttpService

class MyServiceActor extends Actor with MyService {

  def actorRefFactory = context

  def receive = runRoute(myRoute)
}

trait MyService extends HttpService {

  val myRoute =
    path("ping") {
      get {
        respondWithMediaType(MediaTypes.`text/plain`) {
          complete {
            "pong"
          }
        }
      }
    }
}

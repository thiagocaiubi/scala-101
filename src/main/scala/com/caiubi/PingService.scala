package com.caiubi

import akka.actor.Actor
import spray.http.MediaTypes
import spray.routing.HttpService

class PingServiceActor extends Actor with PingService {

  def actorRefFactory = context

  def receive = runRoute(pingRoute)
}

trait PingService extends HttpService {

  val pingRoute =
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

package com.caiubi

import akka.actor.Actor
import spray.json.DefaultJsonProtocol
import spray.routing.HttpService

case class SurfSpot(name: String)

object SurfSpotJsonProtocol extends DefaultJsonProtocol {

  implicit val surfSpotFormat = jsonFormat1(SurfSpot)
}

class SurfSpotServiceActor extends Actor with SurfSpotService {

  def actorRefFactory = context

  def receive = runRoute(surfSpotRoutes)
}

trait SurfSpotService extends HttpService {

  import SurfSpotJsonProtocol._
  import spray.httpx.SprayJsonSupport._

  var surfSpotRoutes = {
    path("surf_spots") {
      get {
        complete(SurfSpot(name = "Gold Coast, Queensland, Australia"))
      }
    }
  }
}
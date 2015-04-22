package com.caiubi

import akka.actor.{ActorRefFactory, Actor}

class RoutesActor extends Actor with Routes {

  override val actorRefFactory: ActorRefFactory = context

  def receive = runRoute(routes)
}

trait Routes extends PingService with SurfSpotService {

  val routes = {
    pingRoute ~
    surfSpotRoutes
  }
}

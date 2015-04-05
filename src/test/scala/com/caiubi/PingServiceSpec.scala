package com.caiubi

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest

class PingServiceSpec extends Specification with Specs2RouteTest with PingService {

  def actorRefFactory = system

  "PingService" should {

    "return pong response for GET requests to /ping" in {
      Get("/ping") ~> pingRoute ~> check {
        responseAs[String] === "pong"
      }
    }

  }
}

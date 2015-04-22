package com.caiubi

import com.caiubi.SurfSpotJsonProtocol._
import org.specs2.mutable.Specification
import spray.http.{HttpCharsets, MediaTypes}
import spray.httpx.SprayJsonSupport._
import spray.testkit.Specs2RouteTest

class SurfSpotServiceSpec extends Specification with Specs2RouteTest with SurfSpotService {

  def actorRefFactory = system

  "SurfSpotsService" should {

    "return SurfSpot instance serialized response for GET requests to /surf_spots" in {
      Get("/surf_spots") ~> surfSpotRoutes ~> check {
        mediaType === MediaTypes.`application/json`
        charset === HttpCharsets.`UTF-8`
        responseAs[SurfSpot] === SurfSpot(name = "Gold Coast, Queensland, Australia")
      }
    }
  }
}

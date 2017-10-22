package server

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.HttpApp
import akka.http.scaladsl.server.Route
import repository.RestaurantRepository
import spray.json.DefaultJsonProtocol

/**
  * Created by abulseed on 10/22/2017.
  */
final case class RestaurantInfo(id: String, data: RestaurantData)

final case class RestaurantData(enName: String, arName: String, closed: Boolean = false)

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val restaurantDataFormat = jsonFormat3(RestaurantData)
  implicit val restaurantInfoFormat = jsonFormat2(RestaurantInfo)
}

object WebServer extends HttpApp with JsonSupport {

  override def routes: Route =
    path("api" / "restaurant") {
      get {
        parameter('closed.as[Boolean]) {
          closed => complete(StatusCodes.Accepted, RestaurantRepository.list(closed))
        }
      } ~ get {
        val ls = RestaurantRepository.listAll()
        complete(StatusCodes.Accepted, ls)
      } ~ post {
        entity(as[RestaurantInfo]) { restaurantInfo =>
          complete(StatusCodes.Accepted, RestaurantRepository.insert(restaurantInfo))
        }
      } ~ put {
        parameter('id.as[String]) {
          id => entity(as[RestaurantInfo]) { restaurantInfo =>
            complete(StatusCodes.Accepted, RestaurantRepository.update(id, restaurantInfo))
          }
        }
      }
    }
}

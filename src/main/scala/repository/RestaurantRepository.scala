package repository

import server.{RestaurantData, RestaurantInfo}

/**
  * Created by abulseed on 10/22/2017.
  */
object RestaurantRepository {
  private var restaurantList = List(
    RestaurantInfo("5d81a479-add9-11e7-b988-0242ac110002", new RestaurantData("3al Ahwa Cafe", "عالقهوة كافيه")),
    RestaurantInfo("5dc8c6e0-add9-11e7-b988-0242ac110002", new RestaurantData("Abdo Kofta", "عبده كفتة")),
    RestaurantInfo("5dc8c9cb-add9-11e7-b988-0242ac110002", new RestaurantData("Abo Adel", "أبو عادل", true)),
    RestaurantInfo("5dc8cbba-add9-11e7-b988-0242ac110002", new RestaurantData("Abou El Sid", "أبو السيد")),
    RestaurantInfo("5dc945e6-add9-11e7-b988-0242ac110002", new RestaurantData("Abou Ghaly", "ابو غالي", true))
  )

  def insert(data: RestaurantInfo): String = {
    restaurantList = restaurantList :+ data
    data.id
  }

  def listAll(): Iterable[RestaurantInfo] = {
    restaurantList
  }

  def list(closed: Boolean): Iterable[RestaurantInfo] = {
    restaurantList.filterNot(rest => rest.data.closed)
  }

  def update(id: String, data: RestaurantInfo): String = {
    restaurantList = restaurantList. filterNot(rest => rest.id equals id)
    restaurantList = restaurantList :+ data
    id
  }
}
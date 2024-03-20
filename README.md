1. git clone https://github.com/SuperMario4242/RestaurantWebService.git
2. cd RestaurantWebService
3. docker-compose up --build
4. Tam , kad ištestuoti servisą, reikia turėti postman aplikacija
5. Servisą galima pasiekti per localhost:80
 1. Restaurant:
    Get all restaurant localhost:80/restaurant
    Get  restaurant by id localhost:80/restaurant/{id}
    POST localhost:80/restaurants
    PUT localhost:80/restaurants/{id}
    DELETE localhost:80/restaurants/{id} 
  2.  Dishes:
    GET Get all dishes localhost:80/dishes
    Get dish by id localhost:80/dish/{id}
    Get dish by restaurant localhost:80/restaurants/{restaurant_id}/dishes
    POST localhost:80/dishes
    PUT localhost:80/dishes/{id}
    DELETE localhost:80/dishes/{id}
 

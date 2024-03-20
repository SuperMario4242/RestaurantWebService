1. git clone https://github.com/SuperMario4242/RestaurantWebService.git
2. cd RestaurantWebService
3. docker-compose up --build
4. Tam , kad ištestuoti servisą, reikia turėti postman aplikacija
5. Servisą galima pasiekti per localhost:80I
6. A. Restaurant:
7. Get all restaurant localhost:80/restaurant
8. Get  restaurant by id localhost:80/restaurant/{id}
9. POST localhost:80/restaurants
10. PUT localhost:80/restaurants/{id}
11. DELETE localhost:80/restaurants/{id}
12. B.  Dishes:
13. GET Get all dishes localhost:80/dishes
14. Get dish by id localhost:80/dish/{id}
15. Get dish by restaurant localhost:80/restaurants/{restaurant_id}/dishes
16. POST localhost:80/dishes
17. PUT localhost:80/dishes/{id}
18. DELETE localhost:80/dishes/{id}
 

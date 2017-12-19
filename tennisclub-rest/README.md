Run the app :
Open a terminal, go in the tennisclubproject folder : cd tennisclubproject
Compile the app : mvn clean install
Open another terminal and go to tennisclub-web folder : cd tennisclub-web
Run the app : mvn tomcat7:run

user
Get all users:
curl -X GET http://localhost:8080/pa165/rest/users
Find user by ID:
curl -X GET http://localhost:8080/pa165/rest/users/1
Create new user:
curl --request POST \
  --url http://localhost:8080/pa165/rest/users/create \
  --header 'content-type: application/json' \
  --data '{
        "password": "password",
	"name": "Max",
	"surname": "Pierre",
	"mail": "max@pierre.cz",
	"phone": "1111111111",
	"dateOfBirth": "1995-12-12"
	 
}'




courts
list courts
curl -X GET \
  --url http://localhost:8080/pa165/rest/courts
get single court
curl -X GET \
  --url http://localhost:8080/pa165/rest/courts/1
delete court
curl -X DELETE \
  --url http://localhost:8080/pa165/rest/courts/1
create new court
curl -X POST \
  --url http://localhost:8080/pa165/rest/courts/create \
  --header 'content-type: application/json' \
  --data '{
        "type": "GRASS",
        "status": "AVAILABLE",
        "longitude": "12"
        "latitude": "14"}'



bookings
list bookings
curl -X GET \
  --url http://localhost:8080/pa165/rest/bookings
get single booking
curl -X GET \
  --url http://localhost:8080/pa165/rest/bookings/1
delete booking
curl -X DELETE \
  --url http://localhost:8080/pa165/rest/bookings/1
create new booking
curl -X POST \
  --url http://localhost:8080/pa165/rest/bookings/create \
  --header 'content-type: application/json' \
  --data '{"idCourt":3,"user1":{"id":1,"mail":"jean@A.cz","name":"Jean","surname":"A","phone":"603123456","dateOfBirth":"2017-03-03 00:00","admin":false},"user2":{"id":3,"mail":"jean3@A.cz","name":"Jean3","surname":"A3","phone":"603123456","dateOfBirth":"2017-05-03 00:00","admin":false},"dateOfBooking":"2017-03-02 01:33","hourOfBooking":"TEN"}'

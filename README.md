# Adidas Test
## How to run
First, we need to run a mysql docker container. 

`docker run --name mysql-rest -v ${PWD}/sql-scripts/init.sql:/docker-entrypoint-initdb.d/init.sql -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=db_rest -e MYSQL_USER=mysql-user -e MYSQL_PASSWORD=123456  -p 3306:3306  mysql:5.7`

After having the mysql running (10-20 seconds of wait), we can run the project using gradle:

`gradle bootRun`

### Insert some data in the API

```
curl -X POST \
  http://localhost:8080/city \
  -H 'Content-Type: application/json' \
  -d '{
	"name": "Madrid"
}'
```

```
curl -X POST \
  http://localhost:8080/city \
  -H 'Content-Type: application/json' \
  -d '{
	"name": "Zaragoza"
}'
```

## Documentation
### [Endpoint] City: /city
#### POST /
Adds a new city
#### GET /
Get all cities
#### GET /{id}
Get city by ID

### [Endpoint] Itinerary: /itinerary
#### POST /
Adds a new itinerary

#### GET / 
Get all itineraries

Params: 
	
	- destination: destination city id
	- origin: origin city id


#### GET /{id}
Get itinerary by ID


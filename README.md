# shopping-list-app-server

This is the server for my shopping list application, created for the Mobilab test assignment.

### Running it on you own computer locally

1) Make sure an instance of Postgre is running

2) Define the right env variables (ones in application.properties)
```
SHOPPING_LIST_APP_DB_URL - url of the host containing port and database name
SHOPPING_LIST_APP_DB_USERNAME
SHOPPING_LIST_APP_DB_PASSWORD
```
3) Initialize the tables in the database using the `db/init.sql` file. 
*NB:* Make sure schema the data is initialized in is the default schema for the database

4) The server can be ran with `gradlew.bat bootRun`

### Or you can use the one I deployed on Heroku
https://desolate-tundra-54863.herokuapp.com/

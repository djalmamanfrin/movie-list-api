# Movie List Api

Basic Application responsible for manage and execute the process described in Especificao_Backend.pdf file in the same path<br/>

## Prerequisites

 General:
 * java: 8 (1.8.0_92)
 * RAM memory:
    * minimum: 512 MB
    * recommended: 1024 MB (1 GB)

 For production environment:
 * Spark Framework
 * Google GSON
 * OpenCSV
 * Reflections

 For development and tests:
 * Junit
 * TngTech Junit dataprovider
 * Mockito

## Installation

* The installation of [Java JDK](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html),
even though it is not installed.<br/>

* Use the [Postman](https://www.getpostman.com/) to test the routes. The routes are [MovieListApi.postman_collection.json](MovieListApi.postman_collection.json) file at the root project   

* Run the maven dependencies

### Configuring or setup
The Default port setted inthe project is 5000. If you are used this port. Change it before run the application.

### Routes
````
* GET - http://127.0.0.1:5000/
* GET - http://127.0.0.1:5000/v1/delete-movie/8ec65ac7-b94b-4ae4-a681-fec0474d2d85
* GET - http://127.0.0.1:5000/v1/ranges-of-awards
* GET - http://127.0.0.1:5000/v1/years-with-more-one-winner
* GET - http://127.0.0.1:5000/v1/winners-studios
* GET - http://127.0.0.1:5000/v1/movies-by-year/1990
* GET - http://127.0.0.1:5000/v1/ranges-of-awards

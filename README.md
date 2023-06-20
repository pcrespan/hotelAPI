# hotel-management-system (under development)

## About
API that simulates a hotel management system. Allows user to register guests, add rooms, stays, employees and many more. The project contains only the back-end.

## Technologies used
* Java
* Spring Boot
* JPA/Hibernate
* Maven
* PostgreSQL

## Usage

### Guest
* `PATH = localhost:8080/guests`

#### Requests

* GET
* GET by id
   * `PATH/{id}`
* POST guest
   * `PATH`
   * JSON keys:
      * name
      * socialSecurityNumber
* POST stay
   * `PATH/{id}/stay`
   * JSON keys:
      * roomId
      * arrival (yyyy-MM-dd)
      * leaving (yyyy-MM-dd)
    
* GET stay by guest id
  * `PATH/{id}/stay`

### Rooms
* `PATH = localhost:8080/rooms`

#### Requests
* GET
* GET by id
   * `PATH/{id}`

### Employees
* `PATH = localhost:8080/employees`

#### Requests
* GET
* GET by id
  * `PATH/{id}`
* POST employee 
  * JSON keys:
    * name
    * status ("ACTIVE"/"INACTIVE")
    * socialSecurityNumber   
* POST contract
  * `PATH/{id}`
  * JSON keys:
    * sectorId
    * salary
    * start
    * roleId
* PUT contract
  * `PATH/{id}`
  * JSON keys:
    * sectorId
    * roleId
    * salary
    * start   

### Sectors
* `PATH = localhost:8080/sectors`

#### Requests
* GET
* GET by id
  * `PATH/{id}`
* POST sector
  * `PATH`
  * JSON keys:
    * name
    * description 

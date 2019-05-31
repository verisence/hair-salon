# Hair Salon.
#### This is a java application that allows the administrator of a hair salon to add, update or delete clients and stylists. 
#### By **Phil Kipkemboi**
## Description
Once the application runs, the administrator can view the stylists, add a new stylist or click on an individual 
stylist to view details. The administrator can also view all the clients, a single one, edit and delete the clients.

## BDD
| Input           | Output            |
|-----------------|-------------------|
| Stylist details | creates a stylist |
| client details  | creates a client  |
| edit a client   | updates a client  |
| edit a stylist  | updates a stylist |

## User Stories
* As a user I should be able to view the stylists.
* As a user I should be add a new stylist.
* As a user I should be able to view client under a stylist.
* As a user I should be able to add a client to a stylist.
* As a user I should be edit stylist.
* As a user I should be delete a stylist.
* As a user I should be edit client.
* As a user I should be delete a client.


### Setup
* To run the application, first install the java development kit from `https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html`
* Install gradle.
* Next clone the project using `$ git clone https://github.com/verisence/hair-salon` to your preferred folder.
* Install Posstgresql using 
`sudo apt-get update 
 sudo apt-get install postgresql postgresql-contrib libpq-dev`
 run
 `sudo -u postgres createuser --superuser $USER`
* Restore the database using
`$ psql name_of_database < schema.sql`
* In the command prompt, navigate to cloned folder and use the following command to run the app `$ gradle run`
* Open the browser and enter the address `localhost:4567`

## Technologies used
* Java.
* Gradle(for unit testing).
* Bootstrap.
* Spark.
* Postgresql
* Material Design Bootstrap.

## License
MIT License

Copyright (c) 2019 Phil Kipkemboi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
Prizy Pricer App
===============

Software needed:
PostgreSQL: http://www.postgresql.org/download/ (I've installed version 9.1)
*The installation and management of the DB will depend on the OS. Please refer to the link above before to preceed.

1) Start the PostgreSQL DB server
2) Create/add the following PostgreSQL superuser:
	 user:fernando, pass: fernando
3) Create the database prizypricer_db
*for further details regarding to user management, please refer to: http://www.postgresql.org/docs/9.1/static/user-manag.html
*for further details regarding to database management, please refer to: http://www.postgresql.org/docs/9.1/static/managing-databases.html
4) Clone the git repo or download and unzip the file pricyprizer.zip
	$ git clone https://github.com/YerbaMate/grails.app.test.git
5) In order to create the tables and fill them with some data, from a PostgreSQL client run the following script:
	/PrizyPricer/script/pricy_prizer_db.sql
6) Go to the root directory of the project (/PrizyPricer), there you will find two scripts named grailsw.sh and grailsw.bat (sh for linux OS and .bat for Windows OS). I will proceed the execution of the script in a linux OS. In windows is the same with the grailsw.bat file.
7) Build the app.
	./grailsw compile
8) Run tests:
	./grailsw test-app
   Choose a particular test to run:
	./grailsw grails test-app Product (This will execute ProductTest.groovy)	
9) Build and run the app:
	./grailsw run-app
10) Open a browser and go to the following url:
	http://localhost:8080/PrizyPricer/
11) Shutdown grails container:
	./grailsw stop-app


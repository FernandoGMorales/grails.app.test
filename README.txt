Prizy Pricer App
===============

Software needed:
PostgreSQL: http://www.postgresql.org/download/

1) Start the PostgreSQL DB server
2) Start a PostgreSQL client, psql is included in the distro
3) From the PostgreSQL client run the following script:
	/script/pricy_prizer_db.sql
4) Clone git repo or download and unzip the file pricyprizer.zip
5) Build the app.
	./grailsw compile
6) Run unit and integration tests:
	./grailsw grails test-app
   Choose what kind of tests to run:
	./grailsw grails test-app unit:
	./grailsw grails test-app integration:
   Choose a particular test to run:
	./grailsw grails test-app Product (This will execute ProductTest.groovy)	
7) Run the app:
	./grailsw run-app
8) Open a browser and go to the following url:
	http://localhost:8080/PrizyPricer/
9) Shutdown grails container:
	./grailsw stop-app


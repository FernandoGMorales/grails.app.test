Prizy Pricer App
===============

Software needed:
Java JRE 6 or higher: http://www.oracle.com/technetwork/java/javase/downloads/jre6downloads-1902815.html
Maven 2: http://maven.apache.org/download.cgi
PostgreSQL: http://www.postgresql.org/download/

1) start the PostgreSQL DB server
2) start a PostgreSQL client, psql is included in the distro
3) from the PostgreSQL client run the following script:
	/script/pricy_prizer_db.sql
4) Unzip the file pricyprizer.zip
5) Build the app (also the following instruction run the unit tests):
	mvn install
To run just the test:
	mvn tests
6) Run the app:
	mvn grails:run-app
7) Open a browser and go to the following url:
	http://localhost:8080/PrizyPricer/



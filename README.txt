Prizy Pricer App
===============

Software needed:
PostgreSQL: http://www.postgresql.org/download/ (I've installed version 9.1)
*The installation and management of the DB will depend on the OS. Please refer to the link above before to preceed.

1) Clone the git repo or download and unzip the file pricyprizer.zip
	git clone https://github.com/YerbaMate/grails.app.test.git
2) Start the PostgreSQL DB server
3) Start a PostgreSQL client, psql is included in the distro
4) From the PostgreSQL client run the following script:
	/PrizyPricer/script/pricy_prizer_db.sql
5) Go to the root directory of the project (/PrizyPricer), there you will find two scripts named grailsw.sh and grailsw.bat (sh for linux OS and .bat for Windows OS). I will proceed the execution of the script in a linux OS. In windows is the same with the grailsw.bat file.
6) Build the app.
	./grailsw compile
7) Run unit and integration tests:
	./grailsw grails test-app
   Choose what kind of tests to run:
	./grailsw grails test-app unit:
	./grailsw grails test-app integration:
   Choose a particular test to run:
	./grailsw grails test-app Product (This will execute ProductTest.groovy)	
8) Run the app:
	./grailsw run-app
9) Open a browser and go to the following url:
	http://localhost:8080/PrizyPricer/
10) Shutdown grails container:
	./grailsw stop-app


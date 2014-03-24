Prizy Pricer App
===============

Welcome to Pricy Pricer!!!
Prizy Pricer is a web application tool to add prices to products. Then the app will calculate/show the different prices for each one based on certain criteria/formula.

In order to run the app in your environment, please follow the instructions below

Software needed:
PostgreSQL: http://www.postgresql.org/download/
*The installation and management of the DB will depend on the OS. Please refer to the link above before to preceed.

1) Start the PostgreSQL DB server
2) Create/add the following PostgreSQL user:
	 user:fernando, pass: fernando
*for further details regarding to user management, please refer to: http://www.postgresql.org/docs/9.1/static/user-manag.html
3) Create the database "pricer_test"
*for further details regarding to database management, please refer to: http://www.postgresql.org/docs/9.1/static/managing-databases.html
4) Unzip the file prizyprizer.zip
5) In order to restore the db state, from a PostgreSQL client run the following script:
	/PrizyPricer/script/prizypricer_db.sql
6) Go to the root directory of the project (/PrizyPricer), there you will find two scripts named grailsw.sh and grailsw.bat. I will proceed the execution of the script in a linux OS.
7) Build the app.
	./grailsw compile
8) Run tests:
	./grailsw test-app	
9) Run the app:
	./grailsw run-app
10) Open a browser and go to the following url:
	http://localhost:8080/PrizyPricer/
11) Shutdown grails container:
	./grailsw stop-app


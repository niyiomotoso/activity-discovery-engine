# System Stack
Frontend: Framework: Vue.js, Package manager: npm.


API: Framework: SpringBoot, Package manager: gradle.


Database: MySQL.


Containerization: Docker.


# Installation
The application is dockerized and composed such that it can be started with a single command.
Ensure [Docker](https://www.docker.com/) is installed on the machine to successfully run. Start the application with the command below.
MySQL DB, Springboot and Vue.js application each has it's own container declaration.


`docker-compose up`


It takes about 6 minutes for all services to be fully setup depending on the local machine VM resources. Please ensure all containers are in running state before using the application.
# Running the application
Once the installation is done:
1. The Springboot API should be live at [localhost:9595](http://localhost:9595)
2. The Vue.js application should be live at [localhost:8080](http://localhost:8080)

NOTE: The default records are automatically populated into the DB by a scheduler that runs at the start of the application.
I also provided an endpoint [http://localhost:9595/trigger](http://localhost:9595/trigger)
that can be used to repopulate the DB incase of new additions.




# Known issue
If the application is failing to start for some reasons or there is an interruption in the starting process. Run the command below to restart the app installation process
`docker-compose down && docker-compose up`


# Running Tests
The test is run with a gradle command. To run the test `cd` to `springboot/demo` directory, then run:

`./gradlew test`


# Design Note
The detailed design note is available in Note.pdf in the parent folder.

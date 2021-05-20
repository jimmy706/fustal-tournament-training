#!/bin/sh
mvn clean package && docker build -t com.axonactive.training/footballtournament-project .
docker rm -f footballtournament-project || true && docker run -d -p 8080:8080 -p 4848:4848 --name footballtournament-project com.axonactive.training/footballtournament-project 

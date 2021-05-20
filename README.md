# Build
mvn clean package && docker build -t com.axonactive.training/footballtournament-project .

# RUN

docker rm -f footballtournament-project || true && docker run -d -p 8080:8080 -p 4848:4848 --name footballtournament-project com.axonactive.training/footballtournament-project 

# Description
Project: ICT futsal tournament

 

ICT companies in Can Tho plan to organize Futsal tournaments (called CT ICT friendship). Let's develop a java-based application to manage registered teams, generate match schedules and record results of matches.

Some requirements:

- A team must have at least 7 players and maximum is 12

- A player must be working for that company (each company has a team)
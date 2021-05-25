# Build
`mvn clean package`

# RUN
`mvn wildfly-jar:run`

# DEV
`mvn wildfly-jar:dev-watch`

# Description
Project: ICT futsal tournament

 

ICT companies in Can Tho plan to organize Futsal tournaments (called CT ICT friendship). Let's develop a java-based application to manage registered teams, generate match schedules and record results of matches.

Some requirements:

- A team must have at least 7 players and maximum is 12

- A player must be working for that company (each company has a team)

# Docker postgress

```
docker run --name fustal-tournament -p 5432:5432 -e POSTGRES_DB=tournamentdb -e POSTGRES_USER=dqdung -e POSTGRES_PASSWORD=Jimmy^active -d postgres:13.3-alpine
```
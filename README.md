# Band Tracker

#### Add your Favorite Band or Venue

#### by Cory Franks 5/13
## Description
A web page made in java that allows you to add Bands and Venues, then assign them to each other using an SQL database

## Setup/Installation Requirements

* Clone repository
* Install Postgres and start it in terminal/command line
* In a new terminal tab type psql
* CREATE DATABASE band_tracker;
* CREATE DATABASE  band_tracker_test WITH TEMPLATE band_tracker
* in bash terminal enter psql band_tracker < band_tracker.sql
* enter "gradle run" in the repositories directory
* in your browser go to "localhost:4567"

## Known Bugs
Currently doesn't display venues on the add a band page and also when you click on a specific venue in the venues list the page wont display

## Technologies Used
* Velocity Template Engine
* Spark
* Java
* Gradle
* Postgres
* SQL
* Heroku

### License

MIT License

Copyright (c) 2016 GDB Media, Inc.

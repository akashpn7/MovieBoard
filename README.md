# MovieBoard
The Challenge

In this project, you'll create a backend application using Java, Spring Boot,
and SQL, leveraging IMDb's extensive datasets. You'll design a robust database
and an API enabling users to search actors and retrieve their movie credits.
Showcase your skills in real-world data handling and API development.


DB Setup

Start with setting up your relational database like MySQL or PostgreSQL.
Tha database schema should be designed in such a way that it can efficiently
store and retrieve actor and movie data.

Download the IMDb dataset from https://datasets.imdbws.com/.
The files name.basics.tsv.gz for the actor data, 
title.basics.tsv.gz for the movie data, and 
title.principles.tsv.gz for the mapping between actors and movies. 

Write a script/service to import and parse the TSV
files and insert the data into your database.


APIs

Design and implement a REST API using Spring Boot.

This API should provide endpoints for:
- Searching for actors by name.
- Retrieving detailed information about an actor, including a list of movies
  they have appeared in.

package com.h2k.dao;

public interface IApplicationQueries {

	
	String insertQuery = "INSERT INTO actor (first_name, last_name, last_update)" +
			" VALUES (? ,?, CURRENT_TIMESTAMP) ";
	
	String selectActorQuery = "SELECT * from Actor";

}

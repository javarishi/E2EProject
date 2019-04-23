package com.h2k.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.h2k.model.ActorDTO;

public class ActorDAO implements IApplicationQueries{
	
	public List<ActorDTO> getActors(){
		
		
		return null;
	}
	
	
	public ActorDTO getActor(int actorId){
		
		
		return null;
	}
	
	
	public int insertActor(ActorDTO actor) throws Exception{
		// implement insert Actor
		Connection conn = DBUtil.getConnection();
		PreparedStatement pStat = conn.prepareStatement(insertQuery);
		pStat.setString(1, actor.getFirstName());
		pStat.setString(2, actor.getLastName());
		int numberofRowsAffected = pStat.executeUpdate();
		DBUtil.closeConnection(conn);
		return numberofRowsAffected;
	}
	
	
	public int updateActor(ActorDTO actor){
		
		
		return 0;
	}
	

}

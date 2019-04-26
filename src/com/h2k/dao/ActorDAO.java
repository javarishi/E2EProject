package com.h2k.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.h2k.model.ActorDTO;

public class ActorDAO implements IApplicationQueries{
	
	
	
	public List<ActorDTO> getActors() throws Exception{
		List<ActorDTO> actors = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(selectActorQuery);
		if(rs!= null) {
			ActorDTO dto = null;
			while (rs.next()) {
				dto = new ActorDTO();
				dto.setActorId(rs.getInt("actor_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setTimestamp(rs.getTimestamp("last_update"));
				actors.add(dto);
			}
		}
		return actors;
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

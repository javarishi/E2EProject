package com.h2k.bo;

import java.util.List;

import com.h2k.dao.ActorDAO;
import com.h2k.exception.InvalidActorException;
import com.h2k.model.ActorDTO;

public class ActorBO {
	
	ActorDAO dao = null;
	
	public ActorBO() {
		dao = new ActorDAO();
	}
	
	public List<ActorDTO> executeGetActors() throws Exception{
			return dao.getActors();
	}
	
	public int executeInsertActor(ActorDTO actor) throws InvalidActorException{
		int result = 0;
		try {
			if(actor != null) {
				if(actor.getFirstName() != null 
						&& actor.getFirstName().trim().length() > 0
						&& actor.getLastName() != null 
						&& actor.getLastName().trim().length() > 0) {
					result  = dao.insertActor(actor);
				}
			}else {
				throw new InvalidActorException("actor is null or Empty");
			}
		}catch(Exception ex) {
			throw new InvalidActorException("Exception in inserting actor"  +  ex.getMessage(), ex);
		}
		return result;
	}

}

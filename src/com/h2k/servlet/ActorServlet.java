package com.h2k.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2k.bo.ActorBO;
import com.h2k.exception.InvalidActorException;
import com.h2k.model.ActorDTO;

public class ActorServlet extends HttpServlet{
	
	ActorBO actorBO = null;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Actor Management Application");
		actorBO =  new ActorBO();
	}
	
	
	
	@Override
	public void doPost(	HttpServletRequest req, 
						HttpServletResponse resp) 
								throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		StringBuilder result = new StringBuilder();
		result.append("<HTML> <Body>");
		
		ActorDTO actor = new ActorDTO();
		actor.setFirstName(firstName);
		actor.setLastName(lastName);
		
		try {
			int num = actorBO.executeInsertActor(actor);
			if(num > 0) {
				result.append("<p> Actor Inserted Successfully </p>");
			}else {
				result.append("<p> Actor NOT Inserted Successfully. But No exceptions </p>");
			}
		} catch (InvalidActorException e) {
			result.append("<p> " + e.getMessage() + " </p>");
			//e.printStackTrace();
		}
		result.append(" </Body> </HTML>");
		
		PrintWriter writer = resp.getWriter();
		writer.println(result.toString());
		
		resp.flushBuffer();
	}
	
}

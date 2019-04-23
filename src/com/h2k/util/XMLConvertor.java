package com.h2k.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.h2k.model.ActorDTO;
import com.thoughtworks.xstream.XStream;

public class XMLConvertor {
	
	private XStream xstream = null;
	
	public XMLConvertor() {
		xstream = new XStream();
		xstream.processAnnotations(ActorDTO.class);
		xstream.processAnnotations(Blog.class);
		xstream.processAnnotations(Entry.class);
	}
	
	public String objectToXML(Object obj) {
		String toXML = xstream.toXML(obj);
		return toXML;
	}
	
	public  void testActor() {
		ActorDTO dto = new ActorDTO();
		dto.setActorId(100);
		dto.setFirstName("Niel");
		dto.setLastName("Armstrong");
		dto.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		XMLConvertor convert = new XMLConvertor();
		String xml = convert.objectToXML(dto);
		System.out.println(xml);
	}
	
	public static void main(String[] args) {
		Entry entryOne = new Entry();
		entryOne.setTitle("first");
		entryOne.setDescription("My first blog entry.");
		
		Entry entryTwo = new Entry();
		entryTwo.setTitle("tutorial");
		entryTwo.setDescription("Today we have developed a nice alias tutorial. Tell your friends! NOW!");
		
		List<Entry> entries = new ArrayList<>();
		entries.add(entryOne);
		entries.add(entryTwo);
		
		Blog blog = new Blog();
		blog.setAuthor("Guilherme Silveira");
		blog.setEntries(entries);
		
		XMLConvertor convert = new XMLConvertor();
		String xml = convert.objectToXML(blog);
		System.out.println(xml);
		
		
	}
}

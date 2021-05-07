package com.test.APIAutomation.OneDat.Resources;

import java.util.ArrayList;

import java.util.List;

import com.test.APIAutomation.OneDat.Pojo.AddBook;
import com.test.APIAutomation.OneDat.Pojo.AddPlace;
import com.test.APIAutomation.OneDat.Pojo.Location;

public class TestBuild {
	
	public AddPlace addPlacePayload(String name,String language,String address)
	{
		AddPlace p =new AddPlace();
	    p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName(name);
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
	}
	public AddBook addBookPayLoad(String name,String isbn,int aisle,String author)
	{
		AddBook bookDetials=new AddBook();
		
		bookDetials.setName(name);
		bookDetials.setIsbn(isbn);
		bookDetials.setAisle(aisle);
		bookDetials.setAuthor(author);
		return bookDetials;	
	}
	
	public String deleteAPIPayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
	
	public String deleteBookPayLoad(String id)
	{
		return "{\r\n  \"ID\" : \""+id+"\"\r\n}";
	}

}

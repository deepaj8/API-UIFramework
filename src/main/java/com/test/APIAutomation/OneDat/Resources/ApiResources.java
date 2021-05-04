package com.test.APIAutomation.OneDat.Resources;

public enum ApiResources {
	
	AddPlaceApi("/maps/api/place/add/json"),
	AddBookApi("/Library/Addbook.php");
	private String resource;
	
	ApiResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}

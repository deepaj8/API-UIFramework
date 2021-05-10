package com.test.APIAutomation.OneDat.Resources;

public enum ApiResources {
	
	AddPlaceApi("/maps/api/place/add/json"),
	GetPlaceApi("/maps/api/place/get/json"),
	DeletePlaceApi("/maps/api/place/delete/json"),
	AddBookApi("/Library/Addbook.php"),
	GetBookApi("/Library/GetBook.php"),
	DeleteBookApi("/Library/DeleteBook.php");
	
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

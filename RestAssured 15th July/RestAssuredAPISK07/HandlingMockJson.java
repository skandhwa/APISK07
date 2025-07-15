package APISK07.RestAssuredAPISK07;

import org.testng.Assert;

import MockJsonResponse.JsonResponse;
import io.restassured.path.json.JsonPath;

public class HandlingMockJson {
	
	public static void main(String[] args) {
	
	
	JsonPath js=new JsonPath(JsonResponse.MockJsonResponse());
	
	//Print No of courses returned by API

	int courseSize=js.getInt("courses.size()");
	System.out.println("The total number of courses is  "+courseSize);
	
	//Print Purchase Amount
	
	int purchaseAmount=js.getInt("dashboard.purchaseAmount");
	System.out.println("The total purchase  amount is  "+purchaseAmount);
	
	//Print Title of the first course

	String courseTitle=js.getString("courses[0].title");
	System.out.println("The first course title is  "+courseTitle);
	
	
	//Print All course titles and their respective Prices
	
	System.out.println("The course title and their price  is ");
	
	for(int i=0;i<courseSize;i++)
	{
	String title=	js.getString("courses["+i+"].title");
	int price=	js.getInt("courses["+i+"].price");
	System.out.print(title+"  ");
	System.out.println(price);
	
	
	
	
	}
	
	//Print no of copies sold by RPA Course
	
	int rpa_coursesize=js.getInt("courses[2].copies");
	
	System.out.println("The total number of rpa copies is  "+rpa_coursesize);

   ////Verify if Sum of all Course prices matches with Purchase Amount
	
	int sum=0;
	for(int i=0;i<courseSize;i++)
	{
		
		int price=	js.getInt("courses["+i+"].price");
		int copies= js.getInt("courses["+i+"].copies");
		int amount =price*copies;
		sum=sum+amount;//sum=0+300=300//sum=300+160=460//sum=460+450
		
		
	}
	
	Assert.assertEquals(sum, purchaseAmount);
	System.out.println("All Test Case Passed");
	
	

	
	
	
    	
	

}
	
}

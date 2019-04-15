package getRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;


public class GetData {
	
	Response responseforpost;
	String id; 
	String BaseUrl = "https://reqres.in/api/users";
	
	//@Test
	public void testGet()
	{
		Response responseget = RestAssured.get(BaseUrl);
		int code = responseget.getStatusCode();
		
		System.out.println("Status code is:"+code);
		Assert.assertEquals(code, 200);
		
	}

	
	
    @Test
    public void testPost() {
    	
    	File file = new File ("C:\\Users\\stamraparni\\eclipse-workspace\\restAssuredFramework\\src\\main\\resources\\request.json");
    	
    	responseforpost = RestAssured.given()
    		    .contentType(ContentType.JSON)
    			.when()
    			.body(file)
    			.post(BaseUrl)
    			.then()
    			.statusCode(201)
    			.extract()
    			.response();
 
    String name = responseforpost.path("name");	
    String job = responseforpost.path("job");   
    id = responseforpost.path("id");    
    
    System.out.println("name:"+name);
    System.out.println("job:"+job);
    
    Assert.assertEquals(name, "Shruthi");
    Assert.assertEquals(job, "Engineer");
    
    }
    
    //@Test
    public void testPatch() {
    	
    	File file = new File ("C:\\Users\\stamraparni\\eclipse-workspace\\restAssuredFramework\\src\\main\\resources\\PatchRequest.json");
    	
    	responseforpost = RestAssured.given()
    		    .contentType(ContentType.JSON)
    			.when()
    			.body(file)
    			.patch(BaseUrl)
    			.then()
    			.statusCode(200)
    			.extract()
    			.response();
 
    String name = responseforpost.path("name");	
    String job = responseforpost.path("job");   
    id = responseforpost.path("id");    
    
    System.out.println("name:"+name);
    System.out.println("job:"+job);
    
    Assert.assertEquals(name, "Rose");
    Assert.assertEquals(job, "Engineer");
    
    }
    
    //@Test
    public void testPut() {
    	
    	File file = new File ("C:\\Users\\stamraparni\\eclipse-workspace\\restAssuredFramework\\src\\main\\resources\\PutRequest.json");
    	
    	responseforpost = RestAssured.given()
    		    .contentType(ContentType.JSON)
    			.when()
    			.body(file)
    			.put(BaseUrl)
    			.then()
    			.statusCode(200)
    			.extract()
    			.response();
 
    String name = responseforpost.path("name");	
    String job = responseforpost.path("job");   
    id = responseforpost.path("id");    
    
    System.out.println("name:"+name);
    System.out.println("job:"+job);
    
    Assert.assertEquals(name, "Lily");
    Assert.assertEquals(job, "Doctor");
    
    }
    
    
    @Test
    public void testDelete() {
    	
    	String DeleteUri = BaseUrl+"/"+id;
    	
    	 ValidatableResponse resp = RestAssured.given()
    		    .when()
    			.delete(DeleteUri)
    			.then()
    			.statusCode(204);
    	
    System.out.println("id:"+resp);
    			
    
    Response responseget = RestAssured.get(DeleteUri);
	int code = responseget.getStatusCode();
	
	System.out.println("Status code is:"+code);
	Assert.assertEquals(code, 404);
    }
    
}

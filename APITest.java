package dummy;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class APITest {
	
	@Test
	public void getMethod()
	{
		String city = "Glasgow";
		// request the server
		Response response = RestAssured.get("http://api.openweathermap.org/data/2.5/forecast?q="+city+",uk&units=metric&appid=1b9a4cf6f5eecebb884e5b6e7144cb98");
		// store the response body in string
		Map<Object, Object> responseBody = (Map<Object, Object>) response.jsonPath().getList("list").get(0);
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println(responseBody.get("weather"));
	}
}
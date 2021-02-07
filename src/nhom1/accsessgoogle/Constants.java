package nhom1.accsessgoogle;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import nhom1.model.GooglePojo;

public class Constants {
	
	public static String GOOGLE_CLIENT_ID = "457798901989-9ujt0a30a9t04709cotfav8er631bbf0.apps.googleusercontent.com";
	public static String GOOGLE_CLIENT_SECRET = "dKcDq5Ip-fGW6WmGmY2YzceU";
	public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/Flash/GoogleLogin";
	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	public static String GOOGLE_GRANT_TYPE = "authorization_code";

	
	
	public static String getToken(final String code) throws ClientProtocolException, IOException {
	    String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
	        .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
	            .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
	            .add("redirect_uri",Constants.GOOGLE_REDIRECT_URI).add("code", code)
	            .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
	        .execute().returnContent().asString();
	      JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
	      String accessToken = jobj.get("access_token").getAsString().replaceAll("\"", "");
	      return accessToken;
	  }

		
		
		

		public GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
			String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
			String response = Request.Get(link).execute().returnContent().asString();
			GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
			return googlePojo;
		}

	
}

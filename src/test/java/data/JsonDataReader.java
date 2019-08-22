package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.xml.Parser;



public class JsonDataReader {
	public String fn,ln,email,ps;
	public void jsonreader() throws FileNotFoundException, IOException, ParseException
	{
		String fPath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";
		File srcF=new File(fPath);
		org.json.simple.parser.JSONParser parser=new org.json.simple.parser.JSONParser();
		JSONArray array=(JSONArray)parser.parse(new FileReader(srcF));

		for(Object jsonObj:array)
		{
			JSONObject person=(JSONObject) jsonObj;
			fn=(String)person.get("firstname");
			System.out.println(fn);
			
			ln=(String)person.get("lastname");
			System.out.println(ln);
			
			email=(String)person.get("email");
			System.out.println(email);
			
			ps=(String)person.get("pass");
			System.out.println(ps);
		}


	}

}

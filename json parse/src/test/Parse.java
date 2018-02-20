package test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class Parse {
	
	public static void  main(String args[]) {
		
		String data=JavaProgram.getData();
		//System.out.println("hello"+data);
		try {
			//Gson g = new Gson();
			JSONObject js = new JSONObject(data);
			JSONArray ja= js.getJSONObject("body").getJSONArray("Recommendations");
		//	System.out.println(js.getJSONObject("body").getJSONArray("Recommendations"));
			//System.out.println(ja.length());
			
			for(int i=0;i<=ja.length()-1;i++)
			{
				JSONObject recommendations=ja.getJSONObject(i);
				System.out.println(recommendations.get("RestaurantName"));
		
					//System.out.println();
					JSONArray menuList =recommendations.getJSONArray("menu");
					//System.out.println(menuList.length());
					for(int j=0;j<menuList.length();j++)
					{
						JSONObject menu = menuList.getJSONObject(j);
						if((menu.get("type").toString()).equals("sectionheader"))
						{
							//System.out.println("here"+i);
						
						JSONArray childrenList = menu.getJSONArray("children");
						 	for(int k=0;k<childrenList.length();k++)
						 	{
						 		JSONObject children=childrenList.getJSONObject(k);
						 		//System.out.println(children.get("type")+""+k+"selected=="+children.get("selected"));
						 		
						 		if(children.get("type").toString().equals("item")&&children.get("selected").toString().equals("1"))
						 			{
//						 			System.out.println("->"+children.get("name"));
						 		
						 			getChildren(children);
						 			
						 			}
						 		
						 	}
						}	
					}
				
			}
			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	
		}
static void getChildren(JSONObject children) throws JSONException
{
	System.out.println("->"+children.get("name"));
}
}


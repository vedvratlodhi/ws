package test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Parse3 {
	
	public static void  main(String args[]) {
		
	
		String data=JavaProgram.getData();
		try { 
			JSONObject js = new JSONObject(data);
			JSONArray ja= js.getJSONObject("body").getJSONArray("Recommendations");
			
				JSONObject recommendations=ja.getJSONObject(0);
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
						 			//System.out.println("->"+children.get("name"));
						 		
						 			getChildren(children,1);
						 			System.out.println("here");
						 			
						 			}
						 		
						 	}
						}	
					}
				
			
			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	
		}
static void getChildren(JSONObject children,int len) throws JSONException
{
	for(int i=0;i<len;i++)
	{
		System.out.print("-");
	}
	System.out.println(">"+children.get("name"));
	JSONArray subchildList=children.getJSONArray("children");
	//System.out.println(subchildList);
	for(int i=0;i<subchildList.length();i++)
	{
		JSONObject subchild = subchildList.getJSONObject(i);
		if(!subchild.get("children").equals(""))
		{
		getChildren(subchild, len+1);
		}else
		{
			//System.out.println(">"+subchild.get("name"));
		}
	}


	
}
}


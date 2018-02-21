package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Bean.Article;
import Bean.Source;

class JsonEncodeDemo {

	   public static void main(String[] args) throws Exception{
	/*      JSONObject obj = new JSONObject();
	      obj.put("name", "shubham");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));
	      
	      String s[]= obj.getNames(obj);
	      for(String s1:s)
	      System.out.println(s1+" : "+obj.get(s1));
	      System.out.print(obj);*/
	      
	      JSONObject news = readJsonFromUrl("https://newsapi.org/v2/top-headlines?country=in&apiKey=6aacf41a7ebc4aafbacae91e85cfd64d");
	     // System.out.println(news.toString());
	    //  System.out.println();
	      JSONArray articleList = news.getJSONArray("articles");
	      List<Article> articleObjectList = new ArrayList<Article>();
	      
	      for(int i=0;i<articleList.length();i++)
	      {
	    	  JSONObject articleJson = articleList.getJSONObject(i);
	    	  Article article = new Article();
	    	  
	    	  	Source source = new Source();
	    	  	source.setId(articleJson.getJSONObject("source").getString("id"));
	    	  	source.setName(articleJson.getJSONObject("source").getString("name"));
	    	  	article.setSource(source);
	    	  	article.setAuthor(articleJson.getString("author"));
	    	  	article.setTitle(articleJson.getString("title"));
	    	  	article.setDescription(articleJson.getString("description"));
	    	  	article.setUrl(articleJson.getString("url"));
	    	  	article.setUrlToImage(articleJson.getString("urlToImage"));
	    	  	article.setPublishedAt(articleJson.getString("publishedAt"));
	    	  	articleObjectList.add(article);
	      }
	      
	     // System.out.println(articleObjectList);
	      for(Article a :articleObjectList)
	      {
	    	  System.out.println(a.getDescription());
	      }
	      
	      
	      
	   }
	   public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONObject json = new JSONObject(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
		  }
	   
	   private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }
	}

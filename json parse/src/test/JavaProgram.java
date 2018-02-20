package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JavaProgram
{
	static StringBuffer  data=new StringBuffer("");
    public static void main(String[] input)
    {
        String fname;
        Scanner scan = new Scanner(System.in);
       
        
        /* enter filename with extension to open and read its content */
        fname = "D:\\test.json";
        /* this will reference only one line at a time */
        
        String line = null;
        try
        {
            FileReader fileReader = new FileReader(fname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                //System.out.println(line);
               data.append(line);
            }
            
            /* always close the file after use */
            bufferedReader.close();
            //System.out.println(data);
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file named '" + fname + "'");
        }
    }
    public static String getData()
    {
    	main(null);
    	
    	return data.toString();
    }
}
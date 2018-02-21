package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

 class JavaProgram
{
	static StringBuffer  data=new StringBuffer("");
    public static void main(String[] input)
    {
        String fname;
        Scanner scan = new Scanner(System.in);
        fname = "D:\\test.json";
        String line = null;
        try
        {
            FileReader fileReader = new FileReader(fname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
               data.append(line);
            }
            bufferedReader.close();
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
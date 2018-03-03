package generateur_test_printf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Generat_Format
{
	
	private void add_flags()
	{
		flags.add(plus);
		flags.add(dash);
		flags.add(space);
		flags.add(zero);
		flags.add(hashtag);
	}
	
	private void add_conversions()
	{
		conversion.add(conversion_h);
		conversion.add(conversion_hh);
		conversion.add(conversion_l);
		conversion.add(conversion_ll);
	}
	
	private void generate_flags()
	{
		for (int a = 0; a < flags.size(); a++)
		{
			format = "%";
			format = format+flags.get(a);
			result.add(format);


			for (int b = 0; b < flags.size(); b++)
			{
				if(a == b && b + 1 < flags.size())
					b++;
				format = format+flags.get(b);
				result.add(format);	
				/*					*/	
				if(a == b + 1)
					b++;
			}
		}
	}
	
	private void generate_conversion()
	{		
		size = result.size();
		for (int c = 0; c < size; c++)
		{
			format = result.get(c);
			for (int d = 0; d < conversion.size(); d++)
			{
				format = format+ conversion.get(d);
				result.add(format);	
			}
		}
	}
	
	private void generate_outPutFiles() 
	{
		generate_simple_outPutFiles();
		generate_outPutFiles_minlength();
		generate_outPutFiles_precision();
		generate_outPutFiles_minlength_precision();
	}
	
	private void generate_simple_outPutFiles()
	{
		size = result.size();
		 try
		 {
			 for (int d = 0; d < type.length(); d++)
			 { 
				 file_name  ="tests//simple_test//test_type_"+ String.valueOf(type.charAt(d)) +".txt";
				 System.out.println(file_name);
				 bufferOutput = new BufferedWriter(new FileWriter (new File (file_name) ));
				 bufferOutput.write("%"+String.valueOf(type.charAt(d))+"\n");
				 for (int c = 0; c < size; c++)
				 {
					 format = result.get(c);
					 format = format + type.charAt(d);
					 bufferOutput.write(format+"\n");
				 }
				 bufferOutput.close();
			 }
		 } catch (Exception e) {
			 // TODO: handle exception
		 }
	}

	private void generate_outPutFiles_minlength()
	{
		size = result.size();
		 try
		 {
			 for (int d = 0; d < type.length(); d++)
			 { 
				 file_name  ="tests//minlength_test//test_type_"+ String.valueOf(type.charAt(d)) +".txt";
				 System.out.println(file_name);
				 bufferOutput = new BufferedWriter(new FileWriter (new File (file_name) ));
				 for (int c = 0; c < size; c++)
				 {
					 format = result.get(c);
					 format = format+ "*" +type.charAt(d);
					 bufferOutput.write(format+"\n");
				 }
				 bufferOutput.close();
			 }
		 } catch (Exception e) {
			 // TODO: handle exception
		 }
	}

	private void generate_outPutFiles_precision()
	{
		size = result.size();
		 try
		 {
			 for (int d = 0; d < type.length(); d++)
			 { 
				 file_name  ="tests//precision_test//test_type_"+ String.valueOf(type.charAt(d)) +".txt";
				 System.out.println(file_name);
				 bufferOutput = new BufferedWriter(new FileWriter (new File (file_name) ));
				 for (int c = 0; c < size; c++)
				 {
					 format = result.get(c);
					 format = format+ ".*" +type.charAt(d);
					 bufferOutput.write(format+"\n");
				 }
				 bufferOutput.close();
			 }
		 } catch (Exception e) {
			 // TODO: handle exception
		 }		
	}

	private void generate_outPutFiles_minlength_precision()
	{
		size = result.size();
		 try
		 {
			 for (int d = 0; d < type.length(); d++)
			 { 
				 file_name  ="tests//minlength_precision_test//test_type_"+ String.valueOf(type.charAt(d)) +".txt";
				 System.out.println(file_name);
				 bufferOutput = new BufferedWriter(new FileWriter (new File (file_name) ));
				 for (int c = 0; c < size; c++)
				 {
					 format = result.get(c);
					 format = format+ "*.*" +type.charAt(d);
					 bufferOutput.write(format+"\n");
				 }
				 bufferOutput.close();
			 }
		 } catch (Exception e) {
			 // TODO: handle exception
		 }		
	}

	public void run()
	{
		add_flags();
		add_conversions();
		
		generate_flags();
		generate_conversion();
	
		generate_outPutFiles();
	}

	public static void main(String[] args)
	{
		Generat_Format exe = new Generat_Format();
		exe.run();
	}

	private BufferedWriter	bufferOutput		= null;
	private String			file_name			= "";

	private ArrayList<String> flags 			= new ArrayList<String>();

	private	String 			plus				= "+";
	private	String 			dash				= "-";
	private String 			space				= " ";
	private	String 			zero				= "0";
	private String 			hashtag				= "#";

	private ArrayList<String> conversion 		= new ArrayList<String>();

	private String conversion_l 				= "l";
	private String conversion_h					= "h";
	private String conversion_ll 				= "l";
	private String conversion_hh 				= "h";

	private ArrayList<String> result			= new ArrayList<String>();

	private String 			format				= "";

	private String type							= "sSpdDioOuUxXcC";

	private int size							= 0;
}
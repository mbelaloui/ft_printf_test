package generateur_test_printf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class format 
{


	public static void main(String[] args) 
	{
		
/*			
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("test.txt")));
			BufferedWriter writer2 = new BufferedWriter(new FileWriter(new File("test3.txt")));
			// normalement si le fichier n'existe pas, il est crée à la racine du projet
//		writer.write(....);
		 
			writer.close();
		}
		catch (IOException e)
		{
		e.printStackTrace();
		}*/
		
		//Nous déclarons nos objets en dehors du bloc try/catch
		FileInputStream fis;
		FileOutputStream fos;
		BufferedInputStream bis;
		BufferedOutputStream bos; 

		try {
			fis = new FileInputStream(new File("test.txt"));
			fos = new FileOutputStream(new File("test2.txt"));
			bis = new BufferedInputStream(new FileInputStream(new File("test.txt")));
			bos = new BufferedOutputStream(new FileOutputStream(new File("test3.txt")));
			byte[] buf = new byte[8];

			//On récupère le temps du système
			long startTime = System.currentTimeMillis();

			while(fis.read(buf) != -1){
				fos.write(buf);
			}
			//On affiche le temps d'exécution
			System.out.println("Temps de lecture + écriture avec FileInputStream et FileOutputStream : " + (System.currentTimeMillis() - startTime));

			//On réinitialise                
			startTime = System.currentTimeMillis();

			while(bis.read(buf) != -1){
				bos.write(buf);
			}
			//On réaffiche
			System.out.println("Temps de lecture + écriture avec BufferedInputStream et BufferedOutputStream : " + (System.currentTimeMillis() - startTime));

			//On ferme nos flux de données
			fis.close();
			bis.close();
			fos.close();
			bos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}     	
	}
}
/* 




 package generateur_test_printf;

import java.util.ArrayList;

public class Generat_Format
{

	private ArrayList<String> flags 		= new ArrayList<String>();

	private	ArrayList<String> conversion	= new ArrayList<String>();

	private	ArrayList<String> result		= new ArrayList<String>();

	private String type = "sSpdDioOuUxXcC";


	private void	set_Flags()
	{
		String plus				= "+";
		String dash				= "-";
		String space			= " ";
		String zero				= "0";
		String hashtag			= "#";

		flags.add(plus);
		flags.add(dash);
		flags.add(space);
		flags.add(zero);
		flags.add(hashtag);
	}

	private void set_conversion()
	{
		String conversion_l 	= "l";
		String conversion_h		= "h";
		String conversion_ll 	= "l";
		String conversion_hh 	= "h";

		conversion.add(conversion_h);
		conversion.add(conversion_hh);
		conversion.add(conversion_l);
		conversion.add(conversion_ll);
	}

	public static void main(String[] args)
	{
			Generat_Format test = new Generat_Format();
			test.run();
	}

	public void run()
	{

		String format = "";

		set_Flags();
		set_conversion();




		for (int a = 0; a < flags.size(); a++)
		{
			format = "";
			format = format + flags.get(a);
			result.add(format);
		//	System.out.println(" a "+a + " "+format);

			for (int b = 0; b < flags.size(); b++)
			{
				if(a == b && b + 1 < flags.size())
					b++;
				format = format + flags.get(b);
				result.add(format);	
				//System.out.print(" b "+b+ " >"+format+"<");
				if(a == b + 1)
					b++;
			}
			System.out.println();
		}


		for (int c = 0; c < flags.size(); c++)
		{
			format = format+flags.get(c);
			System.out.println(format);
/*					for (int d = 3; d < flags.size(); d++)
			{
				format = format+flags.get(d);
				System.out.println(format);	

			}
 */
//	}

/*		
		for (int a = 0; a < flags.size(); a++)
		{
			format = "";
			format = format+flags.get(a);
			result.add(format);


			for (int b = 0; b < flags.size(); b++)
			{
				if(a == b && b + 1 < flags.size())
					b++;
				format = format+flags.get(b);
				result.add(format);	
		/*					*/	
/*				if(a == b + 1)
					b++;
			}
		}
		int taill = result.size();
		for (int c = 0; c < taill; c++)
		{
			format = result.get(c);
			for (int d = 0; d < conversion.size(); d++)
			{
				format = format+ conversion.get(d);
				result.add(format);	
			}
		}
		taill = result.size();

		int num_test = 0;

		for (int d = 0; d < type.length(); d++)
		{
			for (int c = 0; c < taill; c++)
			{
				format = result.get(c);

				format = format+type.charAt(d);
				System.out.println("char *test_"+num_test+" = \""+format+"\";");
				num_test++;
			}
			System.out.println();
		}

		for (int d = 0; d < type.length(); d++)
		{
			for (int c = 0; c < taill; c++)
			{
				format = result.get(c);

				format = format+ "*" +type.charAt(d);
				System.out.println("char *test_"+num_test+" = \""+format+"\";");
				num_test++;
			}
			System.out.println();
		}

		for (int d = 0; d < type.length(); d++)
		{
			for (int c = 0; c < taill; c++)
			{
				format = result.get(c);

				format = format+ ".*" +type.charAt(d);
				System.out.println("char *test_"+num_test+" = \""+format+"\";");
				num_test++;
			}
			System.out.println();
		}

		for (int d = 0; d < type.length(); d++)
		{
			for (int c = 0; c < taill; c++)
			{
				format = result.get(c);

				format = format+ "*.*" +type.charAt(d);
				System.out.println("char *test_"+num_test+" = \""+format+"\";");
				num_test++;
			}
			System.out.println();
		}*/

//}

/*
 * 
				for (int i = 0; i < conversion.size(); i++)
				{
	//				for (int j= i; j <=i; j++)
					{
						format = format+ conversion.get(i);
					}
					System.out.println(format);
				}


/*				for (int c = 0; c < flags.size(); c++)
				{
					format = format+flags.get(c);
					System.out.println(format);
/*					for (int d = 3; d < flags.size(); d++)
					{
						format = format+flags.get(d);
						System.out.println(format);	

					}
//			}




}








 **/

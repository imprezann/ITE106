import java.io.*;

public class TextFileManipulationBufferedReader {

	public static void main(String[] args) throws Exception
	{
	
		File file = new File("imprez.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null)
		{
			System.out.println(st);
		}
	}
}

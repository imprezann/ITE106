import java.io.File;
import java.util.Scanner;
public class TextFileManipulationScannerWithLoop
{
	public static void main(String[] ards) throws Exception
	{
	File file = new File("imprezannanda.txt");
	Scanner sc = new Scanner(file);
	
	while (sc.hasNextLine())
		System.out.println(sc.nextLine());
	}
}
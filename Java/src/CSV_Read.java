
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class CSV_Read {

	@Test
	public void application() throws IOException
	{
		String name="Tumkur";
		CSVReader reader=null;
		try{
			reader=new CSVReader(new FileReader("./Excel/Book1.csv"));
			String cell[]=reader.readNext();
			while((cell=reader.readNext())!=null)
			{
				if(cell[0].contains(name))
				{
					String from=cell[0];
					String To=cell[1];
					String date=cell[2];
					System.out.println(from);
					System.out.println(To);
					System.out.println(date);
					System.out.println("Hii");
				}
				
				
				
			}
		}	
		catch(IOException e){
			e.printStackTrace();

		}
	}
}

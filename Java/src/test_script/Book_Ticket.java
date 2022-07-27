package test_script;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pom_script.POM;
import Jeneric_script.Open_Browser;

public class Book_Ticket extends Open_Browser{
	@Test
	public void login() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String serach_from="Hyderabad";
		CSVReader reader=null;
		try{
			reader=new CSVReader(new FileReader("./Excel/Book1.csv") );
			String cell[]=reader.readNext();
			while((cell=reader.readNext())!=null)
			{
				
				String from=cell[0];
				String To=cell[1];
				String date=cell[2];
				POM p=new POM(driver);
				p.from(from);
				p.from_address();
				p.To(To);
				p.To_address();
				p.date(date);
				p.search_click();
				String bus_count1=p.bus_count();
				FileInputStream fis = new FileInputStream("./Excel/Book2.xlsx");
				Workbook book1=WorkbookFactory.create(fis);
				Sheet sheet1 = book1.getSheet("Sheet1");
				Object data[][]={{"From","To","Date","Bus Count"},
						{from,To,date,bus_count1}};
				int rows=data.length;
				int cols=data[0].length;
				for(int i=0;i<rows;i++)
				{
					Row row1 = sheet1.createRow(i);
					for(int j=0;j<cols;j++)
					{
						Cell cell1 = row1.createCell(j);
						Object value = data[i][j];
						if(value instanceof String)
							cell1.setCellValue((String)value);
						if(value instanceof Integer)
							cell1.setCellValue((Integer)value);
						if(value instanceof Boolean)
							cell1.setCellValue((Boolean)value);
					}
				}
				
				FileOutputStream file1=new FileOutputStream("./Excel/Book2.xlsx");
				book1.write(file1);
				}
			
		}	
		catch(IOException e){
			e.printStackTrace();
		}
	}
}

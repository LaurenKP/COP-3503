import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {
	private String surveyFile = "survey_data.csv";
	private FileWriter fileOutput;
	private PrintWriter printWriter;

	/**
	 * creates file and header that will take GUI data
	 * 
	 */
	public FileHandler()
	{	
		try {
			FileWriter fileOutput = new FileWriter(surveyFile);
			printWriter = new PrintWriter(fileOutput);
			String header = ("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
			printWriter.println(header);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printWriter.close();
		

	}
	/**
	 * appends the surveydata string to the file created in FileHandler method
	 * 
	 */
	public void WriteResults(String surveyData)
	{
		try {
			FileWriter fileOutput = new FileWriter(surveyFile, true);
			PrintWriter printWriter = new PrintWriter(fileOutput);
			printWriter.write(surveyData);
			printWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

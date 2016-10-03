package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AmbulanceCSVDataModel 
{
	String[] ambulanceTableHeader;
	Object[][] ambulanceTableData;
	String ambulanceCSVFile = "ambulances.csv";
	
	public AmbulanceCSVDataModel()
	{
		loadData();
	}
	
	public void loadData()
	{
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(new File(ambulanceCSVFile));
			
			scanner.nextLine();
			String[] header = {"ID","Location","Status","Ambulance"};
			setAmbulanceTableHeader(new String[header.length]);
			setAmbulanceTableHeader(header);
			
			ArrayList<String[]> temp = new ArrayList<String[]>();
			while (scanner.hasNext())
			{
				String[] line = scanner.nextLine().split(",");
				line[1] = "("+line[1]+","+line[2]+")";
				String[] newLine = new String[line.length-1];
				for (int i =0;i<newLine.length;i++)
				{
					if (i > 1)
					{
						line[i+1] = line[i+1].replace("\"","");
						newLine[i] = line[i+1];
					}
					else
					{
						line[i] = line[i].replace("\"","");
						newLine[i] = line[i];
					}
				}
				temp.add(newLine);
			}
			ambulanceTableData = new Object[temp.size()][];
			for (int i = 0;i<temp.size();i++)
			{
				ambulanceTableData[i] = new String[temp.get(i).length];
				ambulanceTableData[i] = temp.get(i);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.print("File not found");
			System.exit(0);
		}
		finally
		{
			if (scanner != null)
				scanner.close();
		}
	}
	
	public void saveAmbulance(Object[] newAmbulanceData) throws IOException
	{
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter(ambulanceCSVFile,true));
			bw.append((String) newAmbulanceData[0] + "," + (String) newAmbulanceData[1] + "," + (String) newAmbulanceData[2]);
		}
		catch (IOException e)
		{
			System.out.print("File not found");
		}
		finally
		{
			if (bw!= null)
				bw.close();
		}
	}

	public String[] getAmbulanceTableHeader() 
	{
		return ambulanceTableHeader;
	}

	public void setAmbulanceTableHeader(String[] ambulanceTableHeader) 
	{
		this.ambulanceTableHeader = ambulanceTableHeader;
	}

	public Object[][] getAmbulanceTableData() 
	{
		return ambulanceTableData;
	}

	public void setAmbulanceTableData(Object[][] ambulanceTableData) 
	{
		this.ambulanceTableData = ambulanceTableData;
	}

	public String getAmbulanceCSVFile() 
	{
		return ambulanceCSVFile;
	}

	public void setAmbulanceCSVFile(String ambulanceCSVFile) 
	{
		this.ambulanceCSVFile = ambulanceCSVFile;
	}
	
}

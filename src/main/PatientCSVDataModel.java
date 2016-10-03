package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientCSVDataModel 
{
	String[] patientTableHeader;
	Object[][] patientTableData;
	String patientCSVFile = "patients.csv";
	
	public PatientCSVDataModel()
	{
		loadData();
	}
	
	public void loadData()
	{
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(new File(patientCSVFile));
			
			scanner.nextLine();
			String[] header = {"ID","Location","Status","Ambulance"};
			setPatientTableHeader(new String[header.length]);
			setPatientTableHeader(header);
			
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
			patientTableData = new Object[temp.size()][];
			for (int i = 0;i<temp.size();i++)
			{
				patientTableData[i] = new String[temp.get(i).length];
				patientTableData[i] = temp.get(i);
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
	
	public void savePatient(Object[] newPatientData) throws IOException
	{
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter(patientCSVFile,true));
			bw.append((String) newPatientData[0] + "," + (String) newPatientData[1] + "," + (String) newPatientData[2]);
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

	public String[] getPatientTableHeader() 
	{
		return patientTableHeader;
	}

	public void setPatientTableHeader(String[] patientTableHeader) 
	{
		this.patientTableHeader = patientTableHeader;
	}

	public Object[][] getPatientTableData() 
	{
		return patientTableData;
	}

	public void setPatientTableData(Object[][] patientTableData) 
	{
		this.patientTableData = patientTableData;
	}

	public String getPatientCSVFile() 
	{
		return patientCSVFile;
	}

	public void setPatientCSVFile(String patientCSVFile) 
	{
		this.patientCSVFile = patientCSVFile;
	}	
}

package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddNewPatientControl 
{
	AddNewPatientPanel addNewPatientPanel;
	public AddNewPatientControl(AddNewPatientPanel panel)
	{
		this.addNewPatientPanel = panel;
		
		this.addNewPatientPanel.getCancelButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MainMenuFrame mainMenuFrame = addNewPatientPanel.getParentFrame().getParentFrame();
				addNewPatientPanel.setVisible(false);
				mainMenuFrame.getPatientsPanel().setVisible(true);
				mainMenuFrame.add(mainMenuFrame.getPatientsPanel(),BorderLayout.CENTER);
			}
		});
		
		this.addNewPatientPanel.getSaveButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				PatientsControl patientsControl = addNewPatientPanel.getPatientsControl();
				MainMenuFrame mainMenuFrame = addNewPatientPanel.getParentFrame().getParentFrame();
				try
				{
					patientsControl.getPatientCSVDataModel().savePatient(addNewPatientPanel.getNewData());
					MainMenuFrame newMainMenuFrame = new MainMenuFrame();
					mainMenuFrame.dispose();
					newMainMenuFrame.add(newMainMenuFrame.getPatientsPanel(),BorderLayout.CENTER);
					newMainMenuFrame.setVisible(true);
				}
				catch(IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
		});
	}
}

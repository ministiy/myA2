package main;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class PatientsControl 
{
	PatientsPanel patientsPanel;
	PatientCSVDataModel patientCSVDataModel;
	ButtonPanel buttonPanel;
	
	public PatientsControl(PatientsPanel panel, PatientCSVDataModel patientCSVDataModel,ButtonPanel buttonPanel	)
	{
		this.patientsPanel = panel;
		this.patientCSVDataModel = patientCSVDataModel;
		this.buttonPanel = buttonPanel;
		
		DefaultTableModel tableModel = (DefaultTableModel) this.patientsPanel.getPatientsTable().getModel();
		tableModel.setDataVector(this.patientCSVDataModel.getPatientTableData() , this.patientCSVDataModel.getPatientTableHeader());
		
		this.buttonPanel.getBackButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MainMenuFrame mainMenuFrame = patientsPanel.getParentFrame();
				patientsPanel.setVisible(false);
				buttonPanel.setVisible(false);
				mainMenuFrame.getMainPanel().setVisible(true);
				mainMenuFrame.getTitlePanel().setVisible(true);
				mainMenuFrame.getTitlePanel().setPanelTitle("Ambulance Tracking System");
				mainMenuFrame.add(mainMenuFrame.getTitlePanel(),BorderLayout.NORTH);
				mainMenuFrame.add(mainMenuFrame.getMainPanel(),BorderLayout.CENTER);
			}
		});
	}
	
}

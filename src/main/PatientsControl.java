package main;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PatientsControl 
{
	PatientsPanel patientsPanel;
	PatientCSVDataModel patientCSVDataModel;
	DefaultTableModel tableModel;
	
	public PatientsControl(PatientsPanel panel, PatientCSVDataModel patientCSVDataModel)
	{
		this.patientsPanel = panel;
		this.patientCSVDataModel = patientCSVDataModel;
		
		tableModel = (DefaultTableModel) this.patientsPanel.getPatientsTable().getModel();
		tableModel.setDataVector(this.patientCSVDataModel.getPatientTableData() , this.patientCSVDataModel.getPatientTableHeader());
		
		this.patientsPanel.getPatientsTable().addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getClickCount() == 1 || e.getClickCount() == 2)
				{
					JTable target = (JTable)e.getSource();
					int row = target.getSelectedRow();
					MainMenuFrame mainMenuFrame = patientsPanel.getParentFrame();
					patientsPanel.setVisible(false);
					String title = "Patient: "+ (String) tableModel.getValueAt(row, 0);
					//mainMenuFrame.getTitlePanel().setPanelTitle(title);
					//mainMenuFrame.add(mainMenuFrame.getTitlePanel(),BorderLayout.NORTH);
					mainMenuFrame.getEditPatientPanel().setRow(row);
					mainMenuFrame.getEditPatientPanel().setTitle(title);
					mainMenuFrame.add(mainMenuFrame.getEditPatientPanel(),BorderLayout.CENTER);
					//mainMenuFrame.add(mainMenuFrame.getEditButtonPanel(),BorderLayout.SOUTH);
				}
			}
		});
		this.patientsPanel.getAddNewButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MainMenuFrame mainMenuFrame = patientsPanel.getParentFrame();
				patientsPanel.setVisible(false);
				mainMenuFrame.getAddNewPatientPanel().setVisible(true);
				mainMenuFrame.add(mainMenuFrame.getAddNewPatientPanel(),BorderLayout.CENTER);
			}
		});
		
		this.patientsPanel.getBackButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MainMenuFrame mainMenuFrame = patientsPanel.getParentFrame();
				patientsPanel.setVisible(false);
				mainMenuFrame.getMainPanel().setVisible(true);
				mainMenuFrame.add(mainMenuFrame.getMainPanel(),BorderLayout.CENTER);
			}
		});
	}

	public PatientCSVDataModel getPatientCSVDataModel() {
		return patientCSVDataModel;
	}

	public void setPatientCSVDataModel(PatientCSVDataModel patientCSVDataModel) {
		this.patientCSVDataModel = patientCSVDataModel;
	}

	public PatientsPanel getPatientsPanel() {
		return patientsPanel;
	}

	public void setPatientsPanel(PatientsPanel patientsPanel) {
		this.patientsPanel = patientsPanel;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
}

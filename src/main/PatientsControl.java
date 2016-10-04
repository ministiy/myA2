package main;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PatientsControl 
{
	PatientsPanel patientsPanel;
	PatientCSVDataModel patientCSVDataModel;
	DefaultTableModel tableModel;
	ListSelectionModel listSelectionModel;
	int row;
	
	public PatientsControl(PatientsPanel panel, PatientCSVDataModel patientCSVDataModel)
	{
		this.patientsPanel = panel;
		this.patientCSVDataModel = patientCSVDataModel;
		
		tableModel = (DefaultTableModel) this.patientsPanel.getPatientsTable().getModel();
		tableModel.setDataVector(this.patientCSVDataModel.getPatientTableData() , this.patientCSVDataModel.getPatientTableHeader());
		
		listSelectionModel = this.patientsPanel.getPatientsTable().getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				int minIndex = lsm.getMinSelectionIndex();
				int maxIndex = lsm.getMaxSelectionIndex();
				for (int i = minIndex;i<=maxIndex;i++)
				{
					if(lsm.isSelectedIndex(i))
						row = i;
				}
				MainMenuFrame mainMenuFrame = patientsPanel.getParentFrame();
				patientsPanel.setVisible(false);
				String title = "Patient: "+ (String) tableModel.getValueAt(row, 0);
				mainMenuFrame.getEditPatientPanel().setRow(row);
				mainMenuFrame.getEditPatientPanel().setTitle(title);
				mainMenuFrame.add(mainMenuFrame.getEditPatientPanel(),BorderLayout.CENTER);
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

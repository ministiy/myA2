package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class AmbulancesControl 
{
	AmbulancesPanel ambulancesPanel;
	AmbulanceCSVDataModel ambulanceCSVDataModel;
	ButtonPanel buttonPanel;
	
	public AmbulancesControl(AmbulancesPanel panel, AmbulanceCSVDataModel ambulanceCSVDataModel,ButtonPanel buttonPanel	)
	{
		this.ambulancesPanel = panel;
		this.ambulanceCSVDataModel = ambulanceCSVDataModel;
		this.buttonPanel = buttonPanel;
		
		DefaultTableModel tableModel = (DefaultTableModel) this.ambulancesPanel.getAmbulancesTable().getModel();
		tableModel.setDataVector(this.ambulanceCSVDataModel.getAmbulanceTableData() , this.ambulanceCSVDataModel.getAmbulanceTableHeader());
		
		this.buttonPanel.getBackButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MainMenuFrame mainMenuFrame = ambulancesPanel.getParentFrame();
				ambulancesPanel.setVisible(false);
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

package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControl
{
	MainPanel mainPanel;
	TitlePanel titlePanel;
	PatientsPanel patientsPanel;
	ButtonPanel buttonPanel;
	
	public MainControl(MainPanel panel,PatientsPanel patientsPanel, ButtonPanel buttonPanel,AmbulancesPanel ambulancesPanel)
	{
		this.mainPanel = panel;
		this.patientsPanel = patientsPanel;
		this.buttonPanel = buttonPanel;
		
		this.mainPanel.getPatientButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MainMenuFrame mainMenuFrame = mainPanel.getParentFrame();
				mainPanel.setVisible(false);
				patientsPanel.setVisible(true);
				mainMenuFrame.add(mainMenuFrame.getPatientsPanel(),BorderLayout.CENTER);
			}
		});
		
		this.mainPanel.getAmbulanceButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MainMenuFrame mainMenuFrame = mainPanel.getParentFrame();
				mainPanel.setVisible(false);
				ambulancesPanel.setVisible(true);
				buttonPanel.setVisible(true);
				titlePanel.setPanelTitle("Ambulances");
				mainMenuFrame.add(titlePanel,BorderLayout.NORTH);
				mainMenuFrame.add(mainMenuFrame.getAmbulancesPanel(),BorderLayout.CENTER);
				mainMenuFrame.add(mainMenuFrame.getButtonPanel(),BorderLayout.PAGE_END);
			}
		});
		
		this.mainPanel.getExitButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
}

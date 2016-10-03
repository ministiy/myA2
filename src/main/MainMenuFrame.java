package main;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainMenuFrame extends JFrame
{
	static final long serialVersionUID = 12L;
	
	String label = "Ambulance Tracker App";
	
	MainPanel mainPanel;
	TitlePanel titlePanel;
	PatientsPanel patientsPanel;
	AmbulancesPanel ambulancesPanel;
	ButtonPanel buttonPanel;
	
	AmbulanceCSVDataModel ambulancesDataModel;
	PatientCSVDataModel patientsDataModel;
	
	MainControl mainControl;
	PatientsControl patientsControl;
	AmbulancesControl ambulancesControl;
	
	public MainMenuFrame()
	{
		createAndShowGUI();
	}
	
	public void createAndShowGUI()
	{
		mainPanel = new MainPanel(this);
		titlePanel = new TitlePanel("Ambulance Tracking System");
		patientsPanel = new PatientsPanel(this);
		ambulancesPanel = new AmbulancesPanel(this);
		buttonPanel = new ButtonPanel();
		
		patientsDataModel = new PatientCSVDataModel();
		ambulancesDataModel = new AmbulanceCSVDataModel();
		
		mainControl = new MainControl(mainPanel,titlePanel,patientsPanel,buttonPanel,ambulancesPanel);
		patientsControl = new PatientsControl(patientsPanel,patientsDataModel,buttonPanel);
		ambulancesControl = new AmbulancesControl(ambulancesPanel,ambulancesDataModel,buttonPanel);
		
		setTitle(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500,400);
		add(titlePanel,BorderLayout.NORTH);
		add(mainPanel,BorderLayout.CENTER);
	}
	public PatientsControl getPatientsControl() {
		return patientsControl;
	}

	public void setPatientsControl(PatientsControl patientsControl) {
		this.patientsControl = patientsControl;
	}

	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(ButtonPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public MainControl getMainControl() {
		return mainControl;
	}

	public void setMainControl(MainControl mainControl) {
		this.mainControl = mainControl;
	}

	public MainPanel getMainPanel() 
	{
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) 
	{
		this.mainPanel = mainPanel;
	}

	public TitlePanel getTitlePanel() 
	{
		return titlePanel;
	}

	public void setTitlePanel(TitlePanel titlePanel) 
	{
		this.titlePanel = titlePanel;
	}

	public PatientsPanel getPatientsPanel() 
	{
		return patientsPanel;
	}

	public void setPatientsPanel(PatientsPanel patientsPanel) 
	{
		this.patientsPanel = patientsPanel;
	}

	public AmbulancesPanel getAmbulancesPanel() 
	{
		return ambulancesPanel;
	}

	public void setAmbulancesPanel(AmbulancesPanel ambulancesPanel) 
	{
		this.ambulancesPanel = ambulancesPanel;
	}

	public AmbulanceCSVDataModel getAmbulanceDataModel() 
	{
		return ambulancesDataModel;
	}

	public void setAmbulanceDataModel(AmbulanceCSVDataModel ambulanceDataModel) 
	{
		this.ambulancesDataModel = ambulanceDataModel;
	}

	public PatientCSVDataModel getPatientsDataModel() 
	{
		return patientsDataModel;
	}

	public void setPatientsDataModel(PatientCSVDataModel patientsDataModel) 
	{
		this.patientsDataModel = patientsDataModel;
	}
	
}

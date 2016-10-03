package main;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel
{
	static final long serialVersionUID = 12L;
	
	MainMenuFrame parentFrame;
	JButton ambulanceButton,patientButton,exitButton;
	TitlePanel titlePanel;
	public MainPanel(MainMenuFrame parent)
	{
		setParentFrame(parent);
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    add(Box.createRigidArea(new Dimension(0,15)));
	    patientButton = new JButton("Patients");
		patientButton.setMaximumSize(new Dimension(150,50));
		
		ambulanceButton = new JButton("Ambulances");
		ambulanceButton.setMaximumSize(new Dimension(150,50));
		
		exitButton = new JButton("Exit");
		exitButton.setMaximumSize(new Dimension(150,50));
		
		patientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		ambulanceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(patientButton);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(ambulanceButton);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(exitButton);
	}
		
	public TitlePanel getTitlePanel()
	{
		return titlePanel;
	}
	
	public JButton getPatientButton() 
	{
		return patientButton;
	}

	public void setPatientButton(JButton patientButton) 
	{
		this.patientButton = patientButton;
	}

	public JButton getAmbulanceButton() 
	{
		return ambulanceButton;
	}

	public void setAmbulanceButton(JButton ambulanceButton) 
	{
		this.ambulanceButton = ambulanceButton;
	}

	public JButton getExitButton() 
	{
		return exitButton;
	}

	public void setExitButton(JButton exitButton) 
	{
		this.exitButton = exitButton;
	}

	public MainMenuFrame getParentFrame() 
	{
		return parentFrame;
	}

	public void setParentFrame(MainMenuFrame parent) 
	{
		this.parentFrame = parent;
	}
	
}

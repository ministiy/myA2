package main;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel 
{
	static final long serialVersionUID = 12L;
	JButton backButton,addNewButton;
	
	public ButtonPanel()
	{
		backButton = new JButton("Back");
		addNewButton = new JButton("Add New");
		
		setLayout(new GridLayout(0,3));
		
		backButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		backButton.setMaximumSize(new Dimension(150,50));
		addNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		addNewButton.setMaximumSize(new Dimension(150,50));
		
		add(backButton);
		add(new JLabel(""));
		add(addNewButton);
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JButton getAddNewButton() {
		return addNewButton;
	}

	public void setAddNewButton(JButton addNewButton) {
		this.addNewButton = addNewButton;
	}
}

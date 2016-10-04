package main;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditButtonPanel extends JPanel 
{
	static final long serialVersionUID = 12L;
	JButton cancelButton,saveButton;
	
	public EditButtonPanel()
	{
		cancelButton = new JButton("Cancel");
		saveButton = new JButton("Save");
		setLayout(new GridLayout(0,3));
		cancelButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		cancelButton.setMaximumSize(new Dimension(150,50));
		saveButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		saveButton.setMaximumSize(new Dimension(150,50));
		
		add(cancelButton);
		add(new JLabel(""));
		add(saveButton);
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

}

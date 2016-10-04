package main;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PatientsPanel extends JPanel 
{
	static final long serialVersionUID = 12L;
	
	JTable patientsTable;
	JScrollPane scrollPane;
	MainMenuFrame parentFrame;
	JLabel title;
	JButton backButton,addNewButton;
	

	public PatientsPanel(MainMenuFrame parent)
	{
		setParentFrame(parent);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JPanel firstPanel = new JPanel();
		title = new JLabel("Patients");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Sans Serif",Font.BOLD,24));
		
		JPanel secondPanel = new JPanel();
		
		backButton = new JButton("Back");
		addNewButton = new JButton("Add New");

		backButton.setMaximumSize(new Dimension(150,50));
		addNewButton.setMaximumSize(new Dimension(150,50));
		
		firstPanel.setLayout(new BoxLayout(firstPanel,BoxLayout.X_AXIS));
		firstPanel.add(title);
		
		secondPanel.setLayout(new BoxLayout(secondPanel,BoxLayout.X_AXIS));
		secondPanel.add(backButton);
		secondPanel.add(Box.createRigidArea(new Dimension(100,0)));
		secondPanel.add(addNewButton);
		
		patientsTable = new JTable();
		scrollPane = new JScrollPane(patientsTable);
		patientsTable.setShowGrid(false);

		patientsTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
		patientsTable.setFillsViewportHeight(true);
		
		add(firstPanel);
		add(scrollPane);
		add(secondPanel);
	}
	
	public JTable getPatientsTable() 
	{
		return patientsTable;
	}

	public void setPatientsTable(Object[][] data, String[] colnames) 
	{
		this.patientsTable.setModel(new DefaultTableModel(data,colnames));
	}

	public JScrollPane getScrollPane() 
	{
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) 
	{
		this.scrollPane = scrollPane;
	}

	public MainMenuFrame getParentFrame()
	{
		return parentFrame;
	}
	
	public void setParentFrame(MainMenuFrame parent)
	{
		this.parentFrame = parent;
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

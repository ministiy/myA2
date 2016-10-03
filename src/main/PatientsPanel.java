package main;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PatientsPanel extends JPanel 
{
	static final long serialVersionUID = 12L;
	
	JTable patientsTable;
	JScrollPane scrollPane;
	MainMenuFrame parentFrame;
	
	public PatientsPanel(MainMenuFrame parent)
	{
		setParentFrame(parent);
		
		patientsTable = new JTable();
		scrollPane = new JScrollPane(patientsTable);
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		patientsTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
		patientsTable.setFillsViewportHeight(true);
		
		add(scrollPane);
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
}

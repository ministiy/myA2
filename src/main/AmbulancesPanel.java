package main;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AmbulancesPanel extends JPanel
{
static final long serialVersionUID = 12L;
	
	JTable ambulancesTable;
	JScrollPane scrollPane;
	MainMenuFrame parentFrame;
	
	public AmbulancesPanel(MainMenuFrame parent)
	{
		setParentFrame(parent);
		
		ambulancesTable = new JTable();
		scrollPane = new JScrollPane(ambulancesTable);
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		ambulancesTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
		ambulancesTable.setFillsViewportHeight(true);
		
		add(scrollPane);
	}
	
	public JTable getAmbulancesTable() 
	{
		return ambulancesTable;
	}

	public void setAmbulancesTable(Object[][] data, String[] colnames) 
	{
		this.ambulancesTable.setModel(new DefaultTableModel(data,colnames));
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

package main;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class TitlePanel extends JPanel
{
	static final long serialVersionUID = 12L;
	
	JLabel panelTitle;
	
	public TitlePanel(String title)
	{
		this.panelTitle = new JLabel(title);
		this.panelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelTitle.setFont(new Font("Sans Serif",Font.BOLD,24));
		add(this.panelTitle);
	}

	public JLabel getPanelTitle() {
		return panelTitle;
	}

	public void setPanelTitle(String newTitle) {
		panelTitle.setText(newTitle);
	}
	
}

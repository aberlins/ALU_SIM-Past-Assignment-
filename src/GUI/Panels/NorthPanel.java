package GUI.Panels;
//*************************************************************************************//
//North Panel which holds the Title of the Application.
//*************************************************************************************//
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NorthPanel extends JPanel
{
	private static final int HEIGHT = 75;
	private static final int TITLE_LABEL_SIZE = 50;
	
	public NorthPanel() 
	{
		setNorthPanel();
	}
	
	private void setNorthPanel() 
	{
		this.setPreferredSize(new Dimension(0, HEIGHT));
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		
		JLabel titleLabel = new JLabel("ALU Simulator");
		titleLabel.setFont(new GUI.ProgramFont(Font.BOLD, TITLE_LABEL_SIZE));
		titleLabel.setForeground(GUI.ProgramFont.FONT_COLOR);
		
		this.add(titleLabel);
	}
	
	
}

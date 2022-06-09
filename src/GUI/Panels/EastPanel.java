package GUI.Panels;
//*************************************************************************************//
//East Panel which holds the two registers/text boxes of the GUI.
//*************************************************************************************//
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Application.Main;
import GUI.ProgramFont;
import GUI.ProgramTextArea;

public class EastPanel extends JPanel
{
	private static final int WIDTH = 250;
	private static final int HEIGHT_SUB_PANELS = 150;
	private static final int WIDTH_TEXTBOX = 75;
	private static final int HEIGHT_TEXTBOX = 50;
	private static final int X_TEXTBOX = 100;
	private static final int Y_TEXTBOX = 75;
	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	
	public GUI.ProgramTextArea reg1 = 
			new GUI.ProgramTextArea(WIDTH_TEXTBOX, HEIGHT_TEXTBOX, 25, true);
	public GUI.ProgramTextArea reg2 = 
			new GUI.ProgramTextArea(WIDTH_TEXTBOX, HEIGHT_TEXTBOX, 25, true);
	private JLabel reg1Graphic;
	public JLabel reg2Graphic;
	
	public EastPanel() 
	{
		setTopPanel();
		setBottomPanel();
		setEastPanel();
	}
	
	private void setEastPanel() 
	{
		this.setPreferredSize(new Dimension(WIDTH, 0));
		this.setLayout(new BorderLayout());
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		this.setBackground(new Color(0,0,0,0));
		
	}
	
	private void setTopPanel() 
	{
		topPanel.setPreferredSize(new Dimension(0, HEIGHT_SUB_PANELS));
		topPanel.setBackground(new Color(0,0,0,0));
		topPanel.setLayout(null);
		
		reg1.setBounds(X_TEXTBOX, Y_TEXTBOX, WIDTH_TEXTBOX, HEIGHT_TEXTBOX);
		reg1Graphic = new GUI.RegLabel("Register 1", "/res/regHapp.png", 5);
		
		topPanel.add(reg1Graphic);
		topPanel.add(reg1);
	}
	
	private void setBottomPanel() 
	{
		bottomPanel.setPreferredSize(new Dimension(0, HEIGHT_SUB_PANELS));
		bottomPanel.setBackground(new Color(0,0,0,0));
		bottomPanel.setLayout(null);
		
		reg2.setBounds(X_TEXTBOX, Y_TEXTBOX, WIDTH_TEXTBOX, HEIGHT_TEXTBOX);
		reg2Graphic = new GUI.RegLabel("Register 2", "/res/regHapp.png", 3);
		
		bottomPanel.add(reg2Graphic);
		bottomPanel.add(reg2);
	}
	
	
	
	
}

package GUI.Panels;
//*************************************************************************************//
//South Panel which holds the Text Area of the GUI.
//*************************************************************************************//
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SouthPanel extends JPanel 
{
	private static final int HEIGHT = 175;
	private static final int WIDTH_ALU_TEXTAREA = 400;
	private static final int HEIGHT_ALU_TEXTAREA = 90;
	private static final int X_ALU_TEXTAREA = 300;
	private static final int Y_ALU_TEXTAREA = 30;
	
	public GUI.ProgramTextArea aluTextArea = 
			new GUI.ProgramTextArea(WIDTH_ALU_TEXTAREA, HEIGHT_ALU_TEXTAREA, 
			14, false);
	private JLabel alu = new JLabel();
	
	public SouthPanel() 
	{
		setSouthPanel();
	}
	
	private void setSouthPanel() 
	{
		this.setPreferredSize(new Dimension(0, HEIGHT));
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		
		aluTextArea.setBounds(X_ALU_TEXTAREA, Y_ALU_TEXTAREA, 
				WIDTH_ALU_TEXTAREA, HEIGHT_ALU_TEXTAREA);
		
		Image img = new ImageIcon(this.getClass().getResource("/res/aluHapp.png")).getImage();
		ImageIcon icon = new ImageIcon(img);
		alu.setIcon(icon);
		alu.setBounds(138, -3, 630, 135);
		
		this.add(alu);
		this.add(aluTextArea);
	}
	
}

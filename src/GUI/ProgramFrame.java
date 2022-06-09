package GUI;
//*************************************************************************************//
//Frame/Window of the GUI of the application.
//Holds a panel which contains 5 sub-panels:
//									- North Panel (Title)
//									- Center Panel (Holds Compute and Clear Button)
//									- South Panel (Holds Text Field to display results)
//									- West Panel (Holds Operation Buttons)
//									- East Panel (Holds Text boxes/Registers for input)
//*************************************************************************************//
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProgramFrame extends JFrame
{
	
	private final int WIDTH = 900;
	private final int HEIGHT = 600;
	
	public GUI.Panels.SuperPanel superPanel =
			new GUI.Panels.SuperPanel();

	public ProgramFrame() 
	{
		setFrame();
		setPanel();
		this.setVisible(true);
	}
	
	private void setFrame() 
	{
		this.setSize(WIDTH,HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground();
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.setTitle("ALU Simulator");
		Image img = new ImageIcon(this.getClass().getResource("/res/aluSimIcon.png")).getImage();
		ImageIcon icon = new ImageIcon(img);
		this.setIconImage(icon.getImage());
	}
	
	private void setPanel() 
	{
		superPanel.setPreferredSize(new Dimension(900,600));
		this.add(superPanel);
	}
	
	private void setBackground() 
	{
		Image img = new ImageIcon(this.getClass().getResource("/res/background.png")).getImage();
		ImageIcon icon = new ImageIcon(img);
		JLabel label = new JLabel();
		label.setIcon(icon);
		label.setPreferredSize(new Dimension(900,600));
		this.setContentPane(label);
	}
	

}

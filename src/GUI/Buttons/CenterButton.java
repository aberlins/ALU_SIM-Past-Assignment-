package GUI.Buttons;
//*************************************************************************************//
//Buttons used for the Clear and Compute Buttons in the GUI.
//*************************************************************************************//
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

import javax.swing.BorderFactory;

public class CenterButton extends JButton{
	
	private static final Color BUTTON_COLOR =
			new Color(120, 200, 150);
	public static final int WIDTH = 125;
	public static final int HEIGHT = 50;

	public CenterButton(String message) 
	{
		super(message);
		this.setFont(new GUI.ProgramFont(Font.BOLD, 20));
		this.setForeground(Color.white);
		this.setBackground(BUTTON_COLOR);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBorder(BorderFactory.createRaisedSoftBevelBorder());
	}
	
}

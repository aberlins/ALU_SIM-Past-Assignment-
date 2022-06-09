package GUI.Buttons;
//*************************************************************************************//
//Buttons used for the Operation Buttons in the GUI.
//*************************************************************************************//
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import GUI.ProgramFont;

public class OperationButton extends JButton
{
	
	public OperationButton(String message) 
	{
		super(message);
		this.setFont(new GUI.ProgramFont(Font.BOLD, 20));
		this.setForeground(GUI.ProgramFont.OPBUTTON_FONT_COLOR);
		this.setBackground(Color.lightGray);
		this.setBorder(BorderFactory.createRaisedSoftBevelBorder());
	}
}

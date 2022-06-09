package GUI;
//*************************************************************************************//
//Text Area (Bottom Text Field) used for the GUI of the application.
//*************************************************************************************//
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class ProgramTextArea extends JTextArea 
{
	public ProgramTextArea(int width, int height, int fontSize, boolean editable) 
	{
		this.setPreferredSize(new Dimension(width, height));
		this.setFont(new ProgramFont(Font.PLAIN, fontSize));
		this.setForeground(ProgramFont.FONT_COLOR);
		this.setCaretColor(ProgramFont.FONT_COLOR);
		this.setBackground(Color.black);
		this.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		this.setEditable(editable);
	}
	

}

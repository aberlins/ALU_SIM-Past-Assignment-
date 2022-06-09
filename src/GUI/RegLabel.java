package GUI;
//*************************************************************************************//
//Label used to display images of the registers/text boxes of the GUI.
//*************************************************************************************//
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RegLabel extends JLabel
{
	
	public RegLabel(String regName, String picName, int verticalAlignment) 
	{
		this.setText(regName);
		this.setIconTextGap(-82);
		this.setVerticalTextPosition(JLabel.BOTTOM);
		this.setFont(new GUI.ProgramFont(Font.BOLD, 11));
		this.setForeground(GUI.ProgramFont.REGISTER_FONT_COLOR);
		Image img = new ImageIcon(this.getClass().getResource(picName)).getImage();
		ImageIcon icon = new ImageIcon(img);
		this.setIcon(icon);
		this.setBounds(83, verticalAlignment, 150, 150);
	}
}

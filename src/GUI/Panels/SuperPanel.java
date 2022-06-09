package GUI.Panels;
//*************************************************************************************//
//Super Panel which holds all 5 sub panels of the GUI.
//*************************************************************************************//
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class SuperPanel extends JPanel
{
	
	public GUI.Panels.SouthPanel south =
			new GUI.Panels.SouthPanel();
	public GUI.Panels.WestPanel west = 
			new GUI.Panels.WestPanel();
	public GUI.Panels.EastPanel east =
			new GUI.Panels.EastPanel();
	public GUI.Panels.NorthPanel north =
			new GUI.Panels.NorthPanel();
	public GUI.Panels.CenterPanel center =
			new GUI.Panels.CenterPanel();
	
	public SuperPanel() 
	{
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(new BorderLayout());
		this.add(south, BorderLayout.SOUTH);
		this.add(west, BorderLayout.WEST);
		this.add(east, BorderLayout.EAST);
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
	}
}

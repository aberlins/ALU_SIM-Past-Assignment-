package GUI.Panels;
//*************************************************************************************//
//Center Panel which holds the Clear and Compute Buttons.
//*************************************************************************************//
import java.awt.Color;
import javax.swing.JPanel;

public class CenterPanel extends JPanel 
{
	private static final int Y_BUTTONS = 120;
	private static final int X_COMPUTE_BUTTON = 100;
	private static final int X_CLEAR_BUTTON = 275;
	
	public GUI.Buttons.CenterButton computeButton =
			new GUI.Buttons.CenterButton("Compute");
	public GUI.Buttons.CenterButton clearButton =
			new GUI.Buttons.CenterButton("Clear");
	
	public CenterPanel() 
	{
		setCenterPanel();
	}
	
	public void setCenterPanel() 
	{
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		
		
		computeButton.setBounds(X_COMPUTE_BUTTON, Y_BUTTONS, 
				computeButton.WIDTH, computeButton.HEIGHT);
		clearButton.setBounds(X_CLEAR_BUTTON, Y_BUTTONS, 
				clearButton.WIDTH, clearButton.HEIGHT);
		
		this.add(computeButton);
		this.add(clearButton);
	}

}

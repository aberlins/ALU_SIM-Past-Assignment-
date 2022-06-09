package GUI.Panels;
//*************************************************************************************//
//South Panel which holds the operation buttons of the GUI.
//*************************************************************************************//
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WestPanel extends JPanel 
{
	private static final int WIDTH = 200;
	private static final int BORDER_WIDTH = 17;
	private static final int BORDER_HEIGHT = 30;
	private static final int TITLE_HEIGHT = 100;
	private static final int BUTTON_ROWS = 3;
	private static final int BUTTON_COLUMNS = 2;
	private static final int BUTTON_MARGIN = 10;
	private static final int TITLE_LABEL_SIZE = 30;
	private JPanel titlePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	public GUI.Buttons.OperationButton plusButton = 
			new GUI.Buttons.OperationButton("+");
	public GUI.Buttons.OperationButton minusButton = 
			new GUI.Buttons.OperationButton("-");
	public GUI.Buttons.OperationButton andButton = 
			new GUI.Buttons.OperationButton("and");
	public GUI.Buttons.OperationButton orButton = 
			new GUI.Buttons.OperationButton("or");
	public GUI.Buttons.OperationButton notButton = 
			new GUI.Buttons.OperationButton("not");
	public GUI.Buttons.OperationButton compareButton = 
			new GUI.Buttons.OperationButton("compare");
	
	public WestPanel() 
	{
		setButtonPanel();
		setTitlePanel();
		setWestPanel();
	}
	
	private void setWestPanel() 
	{
		this.setPreferredSize(new Dimension(WIDTH, 0));
		this.setLayout(new BorderLayout());
		
		this.add(buttonPanel, BorderLayout.CENTER);
		this.add(makeBorder(), BorderLayout.WEST);
		this.add(makeBorder(), BorderLayout.SOUTH);
		this.add(titlePanel, BorderLayout.NORTH);
		
		this.setBackground(new Color(0,0,0,0));
	}
	
	private void setButtonPanel() 
	{
		buttonPanel.setLayout(new GridLayout(BUTTON_ROWS,BUTTON_COLUMNS,
				BUTTON_MARGIN,BUTTON_MARGIN));
		buttonPanel.setBackground(new Color(0,0,0,0));
		buttonPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		buttonPanel.add(plusButton);
		buttonPanel.add(minusButton);
		buttonPanel.add(andButton);
		buttonPanel.add(orButton);
		buttonPanel.add(notButton);
		buttonPanel.add(compareButton);
		
	}
	
	private void setTitlePanel() 
	{
		titlePanel.setPreferredSize(new Dimension(0, TITLE_HEIGHT));
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(0,0,0,0));
		
		JLabel titleLabel = new JLabel("Operations");
		titleLabel.setFont(new GUI.ProgramFont(Font.BOLD, TITLE_LABEL_SIZE));
		titleLabel.setForeground(GUI.ProgramFont.FONT_COLOR);
		titleLabel.setBounds(24, 0, 200, 125);
		
		titlePanel.add(titleLabel);
	}
	
	private JPanel makeBorder() {
		
		JPanel border = new JPanel();
		border.setPreferredSize(new Dimension(BORDER_WIDTH, BORDER_HEIGHT));
		border.setBackground(new Color(0,0,0,0));
		
		return border;
	}
	
}

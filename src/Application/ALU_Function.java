package Application;
//*************************************************************************************//
//ALU_Function Class
//
//Description: A class which acts as the GUI for the ALU class, uses the StringReturner
//			   class to communicate and send requests from the ALU class, and then
//			   receives the results/output which is displayed on the bottom text field.
//
//*************************************************************************************//
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ALU_Function implements ActionListener
{
	private GUI.ProgramFrame frame = new GUI.ProgramFrame();
	private String operation = "";
	
	/*Method used to instantiate an instance of the ALU_Function class
	with all buttons given this class as their action listener.*/
	public ALU_Function() 
	{
		displayInitialInstructions();
		frame.superPanel.center.computeButton.addActionListener(this);
		frame.superPanel.center.clearButton.addActionListener(this);
		frame.superPanel.west.plusButton.addActionListener(this);
		frame.superPanel.west.minusButton.addActionListener(this);
		frame.superPanel.west.orButton.addActionListener(this);
		frame.superPanel.west.andButton.addActionListener(this);
		frame.superPanel.west.notButton.addActionListener(this);
		frame.superPanel.west.compareButton.addActionListener(this);
	}

	/*Action Performed Method used to listen to any of the 8 buttons/options
	present: + (Addition), - (Subtraction), and, or, not, compare, compute and
	clear.*/
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Compute Button
		if (e.getSource() == frame.superPanel.center.computeButton)
			computeButtonFunction();
		//Clear Button
		else if (e.getSource() == frame.superPanel.center.clearButton) 
		{
			displayInitialInstructions();
			operation = "";
			frame.superPanel.east.reg2.enable(true);
			clearRegister(3);
		}
		//Addition Button
		else if (e.getSource() == frame.superPanel.west.plusButton) 
		{
			operation = "+";
			frame.superPanel.east.reg2.enable(true);
			frame.superPanel.south.aluTextArea.setText
			(StringReturner.instructionMessage(2));
		}
		//Subtraction Button
		else if (e.getSource() == frame.superPanel.west.minusButton) 
		{
			operation = "-";
			frame.superPanel.east.reg2.enable(true);
			frame.superPanel.south.aluTextArea.setText
			(StringReturner.instructionMessage(3));
		}
		//And Button
		else if (e.getSource() == frame.superPanel.west.andButton) 
		{
			operation = "and";
			frame.superPanel.east.reg2.enable(true);
			frame.superPanel.south.aluTextArea.setText
			(StringReturner.instructionMessage(4));
		}
		//Or Button
		else if (e.getSource() == frame.superPanel.west.orButton) 
		{
			operation = "or";
			frame.superPanel.east.reg2.enable(true);
			frame.superPanel.south.aluTextArea.setText
			(StringReturner.instructionMessage(5));
		}
		//Not Button
		else if (e.getSource() == frame.superPanel.west.notButton) 
		{
			operation = "not";
			frame.superPanel.east.reg2.enable(false);
			clearRegister(2);
			frame.superPanel.south.aluTextArea.setText
			(StringReturner.instructionMessage(6));
		}
		//Compare Button
		else if (e.getSource() == frame.superPanel.west.compareButton) 
		{
			operation = "compare";
			frame.superPanel.east.reg2.enable(true);
			frame.superPanel.south.aluTextArea.setText
			(StringReturner.instructionMessage(7));
		}
	}
	
	/*Helper method used to display a default instructional prompt to the user.*/
	private void displayInitialInstructions() 
	{
		frame.superPanel.south.aluTextArea.setText
		(StringReturner.instructionMessage(1));
	}
	
	/*Helper method which clears any input from the text boxes/registers.
	Takes in an integer to perform different clearing actions:
		1 - clear text box 1
		2 - clear text box 2
		3 - clear both boxes*/
	private void clearRegister (int registerMarker) 
	{
		switch (registerMarker)
		{
			case 1: 
				frame.superPanel.east.reg1.setText("");
				break;
			case 2:
				frame.superPanel.east.reg2.setText("");
				break;
			case 3:
				frame.superPanel.east.reg1.setText("");
				frame.superPanel.east.reg2.setText("");
				break;
		}
	}
	
	/*Helper Method used to compute the results of the given value(s) and
	operation selected by the user.*/
	private void computeButtonFunction () 
	{
		//Check if an operation was selected.
		if (operation.equals("")) 
		{
			frame.superPanel.south.aluTextArea.setText
				(StringReturner.errorMessage(4));
		}
		else {
			//If the operation is not then check that text box/register 1 has input
			if (operation.equals("not")) 
			{
				if (frame.superPanel.east.reg1.getText().equals(""))
					frame.superPanel.south.aluTextArea.setText
						(StringReturner.errorMessage(6));
				else 
				{
					//Validate the input and then return the results
					if (validInput(1)) 
					{
						int reg1Value = Integer.parseInt(getRegisterText(1));
						frame.superPanel.south.aluTextArea.setText(
						StringReturner.getResultString(reg1Value, 0, operation));
					}
				}
			}
			//Check if the text boxes/register have any input
			else if (frame.superPanel.east.reg1.getText().equals("") ||
					frame.superPanel.east.reg2.getText().equals(""))
			{
				frame.superPanel.south.aluTextArea.setText
					(StringReturner.errorMessage(5));
			}
			//Validate both text boxes/register's input and then perform the 
			//selected operation on both values.
			else 
			{
				boolean input1 = validInput(1);
				boolean input2 = validInput(2);
				
				if (input1 && input2)
				{
					int reg1Value = Integer.parseInt(getRegisterText(1));
					int reg2Value = Integer.parseInt(getRegisterText(2));
					frame.superPanel.south.aluTextArea.setText(
					StringReturner.getResultString(reg1Value, 
							reg2Value, operation));
				}
			}
		}
	}
	
	/*Helper Method used to check if the proper input was given to the
	text boxes/registers; that being a signed 8-bit integer.*/
	private boolean validInput (int registerMarker) 
	{
		//First check if the input made up of only digits
		if (isDigit(getRegisterText(registerMarker))) 
		{
			//Then check if input has more then 4 digit places
			if (getRegisterText(registerMarker).length() > 4) 
			{
				frame.superPanel.south.aluTextArea.setText
				(StringReturner.errorMessage(2));
				clearRegister(registerMarker);
				return false;
			}
			else 
			{
				//Convert the string value to an integer and then check its range.
				int userNumber = 
						Integer.parseInt(getRegisterText(registerMarker));
				if (isIn8BitRange(userNumber) == false) 
				{
					frame.superPanel.south.aluTextArea.setText
					(StringReturner.errorMessage(2));
					clearRegister(registerMarker);
					return false;
				}
			}	
		}
		else 
		{
			frame.superPanel.south.aluTextArea.setText
			(StringReturner.errorMessage(1));
			clearRegister(registerMarker);
			return false;
		}
		
		//If all conditions are met then return true.
		return true;
	}
	
	/*Helper Method which obtains the text/input in a given text box/register*/
	private String getRegisterText (int registerMarker) 
	{
		switch (registerMarker) {
				case 1: 
					return frame.superPanel.east.reg1.getText();
				case 2: 
					return frame.superPanel.east.reg2.getText();
				default: 
					return "Invalid request";
		}
	}
	
	/*Method used to check the range of the user's input. Returns
	false if the value is too large.*/
	private boolean isIn8BitRange (int userNumber) 
	{
		if (userNumber > 127 || userNumber < -128)
			return false;
		else 
			return true;
	}
	
	/*Method used to check if the string is a proper numeric value.
	Returns false if it is not. -0 is treated if it is 0.*/
	private boolean isDigit(String userInput) 
	{
		//User input is converted to a character array for
		//easier sorting.
		char [] isNumber = userInput.toCharArray();
		//Used to skip passed a negative sign.
		int index = 0;
		
		//If the number is negative the "-" is ignored.
		if (isNumber[0] == '-') 
		{
			if (isNumber.length > 1) 
				index++;
			else
				return false;
		}
		
		//The user's input is searched to make sure
		//all characters are digits. False is returned if
		//a non-numeric character is found.
		for (int i = index; i < isNumber.length; i++) 
		{
			if (Character.isDigit(isNumber[i]) == false)
				return false;
		}
		
		return true;
	}
}

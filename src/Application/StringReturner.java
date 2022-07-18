package Application;
//*************************************************************************************//
//StringReturner Class
//
//Description: A class which interfaces with the ALU_Function class (GUI) and the 
//			   ALU class (Program's Functionality). Returns strings that are to
//			   be displayed in the bottom text field of the ALU_Function class.
//
//*************************************************************************************//
public class StringReturner 
{
	private ALU alu = new ALU();
	
	public StringReturner() 
	{}
	
	/*Method used to return the results of an operation requested by the user.*/
	public static String getResultString (int userValue1, int userValue2, String operation) 
	{
		//Instance of the class made to access non-static methods
		StringReturner sr = new StringReturner();
		//String used to store results from the operation
		String returnString = "";
		
		//Get the first value that was input in the application
		sr.setBinaryValue(userValue1, 1);
		
		//Single value operations
		if (operation.equals("not"))
			returnString = sr.not();
		//Double value operations
		else
		{
			sr.setBinaryValue(userValue2, 2);
			
			switch (operation) 
			{
				case "+":
					returnString = sr.add();
					break;
				case "-":
					returnString = sr.subtract();
					break;
				case "and":
					returnString = sr.and();
					break;
				case "or":
					returnString = sr.or();
					break;
				case "compare":
					returnString = sr.compare();
					break;
			}
		}
		
		//Reset all binary values for the next calculation.
		sr.alu.resetBinaryValues();
		
		return returnString;
	}
	
	/*Method used to return a string representing any current errors that the 
	application has run into.*/
	public static String errorMessage(int error) 
	{
		switch (error) 
		{
			case 1: 
				return "Please enter only digits-!!";
			case 2:
				return "Please enter an integer of the proper range-!";
			case 3:
				return "Error: Overflow Detected!";
			case 4:
				return "Please select an operation!";
			case 5:
				return "You need to enter two values to perform\nthis operation!";
			case 6:
				return "You need to enter at least one value to\nperform this"
						+ " operation!";
			default:
				return "An error has occured!!!";
		}
	}
	
	/*Method used to return a string representing what option that the
	user has currently selected.*/
	public static String instructionMessage(int instruction) 
	{
		switch (instruction) 
		{
			case 1: return "Please enter one or more 8-bit signed integers\nand then "
					+ "choose your operation!";
			case 2: return "Addition selected!";
			case 3: return "Subtraction selected!";
			case 4: return "And selected!";
			case 5: return "Or selected!";
			case 6: return "Not selected!";
			case 7: return "Compare selected!";
			default: return "This isn't suppose to display, uh oh-!";
		}
	}
	
	/*Method used to set the value of the binary array(s).
	A marker is used to decide which of the two arrays to assign
	a value to.*/
	private void setBinaryValue(int userValue, int binaryValueMarker) 
	{
		//Sets the binary array based on whether it is a positive or
		//negative value.
		if (userValue > -1)
				alu.setPositiveBinaryValue(userValue, binaryValueMarker);
		else
			alu.setNegativeBinaryValue(userValue, binaryValueMarker);
	}
	
	/*Helper method used to perform addition on two binary values.
	Checks if an overflow would occur before adding the two values.
	If not the values are added and the results are displayed
	in binary and decimal.*/
	private String add()
	{
		//Decimal values are gathered to check if an overflow
		//would occur.
		int decimalValue1 = alu.getBinaryValue(1);
		int decimalValue2 = alu.getBinaryValue(2);
		
		if ((decimalValue1 + decimalValue2) > 127 ||
				(decimalValue1 + decimalValue2) < -128)
			return errorMessage(3);
		
		//Values are added and displayed if possible.
		else 
		{
			alu.add();
			return "Binary: " + alu.printBinaryValue(3)
					+ "Decimal Value: " + alu.getBinaryValue(3);
		}
	}

	/*Helper method used to perform subtraction on two binary values.
	Checks if an overflow would occur before adding the two values.
	If not the values are subtracted and the results are displayed
	in binary and decimal.*/
	private String subtract() 
	{
		//Decimal values are gathered to check if an overflow
		//would occur.
		int decimalValue1 = alu.getBinaryValue(1);
		int decimalValue2 = alu.getBinaryValue(2);
		
		if ((decimalValue1 - decimalValue2) < -128
				|| (decimalValue1 - decimalValue2) > 127)
			return errorMessage(3);
		//Values are subtracted and displayed if possible.
		else 
		{
				alu.subtract();
				return "Binary: " + alu.printBinaryValue(3) 
						+ "Decimal Value: " + alu.getBinaryValue(3);
		}
	}
	
	/*Helper method used to perform the and operation between two
	binary values. The second binary value is displayed as a 
	binary and decimal value.*/
	private String and() 
	{
		alu.and();
		return alu.printBinaryValue(1) + "and " +
				 alu.printBinaryValue(2) +
		"\nBinary: " + alu.printBinaryValue(3) + 
				"Decimal Value: " + alu.getBinaryValue(3);
	}
	
	/*Helper method used to perform the or operation between two
	binary values. The first binary value is displayed as a 
	binary and decimal value.*/
	private String or() 
	{
		alu.or();
		return alu.printBinaryValue(1) + "or " +
				 alu.printBinaryValue(2) +
		"\nBinary: " + alu.printBinaryValue(3) + 
				"Decimal Value: " + alu.getBinaryValue(3);
	}
	
	/*Helper method used to perform the compare operation between
	two binary values. If both values are equal "Equal" is printed,
	else "Not equal" is printed.*/
	private String compare() 
	{
		//Binary values are converted to strings and compared
		//via using those methods.
		String binaryValue1 = alu.printBinaryValue(1);
		String binaryValue2 = alu.printBinaryValue(2);
		
		if (binaryValue1.equals(binaryValue2))
			return "Equal.";
		else
			return "Not equal.";
	}
	
	/*Helper method used to perform the not operation of a single
	binary value. The value is displayed as a binary and decimal.*/
	private String not() 
	{
		return "Not " + alu.printBinaryValue(1) +
		"\nBinary: " + alu.printBinaryValue(1) + 
				"Decimal Value: " + alu.getBinaryValue(1);
	}
	
	
	
}

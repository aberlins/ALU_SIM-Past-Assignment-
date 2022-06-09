package Application;
//*************************************************************************************//
//ALU Class
//
//Description: A class which calculates the binary value given a signed integer of an
//			   8-bit range and vice versa, can add or subtract two binary values of 
//			   an 8-bit range and can print said values as a string.
//
//*************************************************************************************//
public class ALU {

	//Class Variables.
	private final int MAX_BIT_LENGTH = 8;
	private int [] binaryValue1 = new int [MAX_BIT_LENGTH]; 
	private int [] binaryValue2 = new int [MAX_BIT_LENGTH]; 
	private int [] binaryResult = new int [MAX_BIT_LENGTH]; 
	
	/*Default Constructor. Sets all values of the three binary arrays to zero.*/
	public ALU() 
	{
		resetBinaryValues();
	}
	
	/*Resets all three values of the three binary arrays to zero.*/
	protected void resetBinaryValues () 
	{
		resetBinaryValue(1);
		resetBinaryValue(2);
		resetBinaryValue(3);
	}
	
	/*Helper method which resets a specific binary array given the proper
	marker. (1 = binaryValue1, 2 = binaryValue2, and 3 = binaryResult.)*/
	private void resetBinaryValue(int binaryValueMarker) 
	{
		//Sets temporary array
		int [] tempBinaryArray = setTempBinaryArray(binaryValueMarker);
		
		//Fills array with all 0s
		for (int i = 0; i < MAX_BIT_LENGTH; i++) 
		{
			tempBinaryArray[i] = 0;
		}
	}
	
	/*Adds both the binary arrays and stores said value in the binary
	result array.*/
	protected void add () 
	{
		//Boolean used to keep track of any 
		//carry over bit.
		boolean carryOverBit = false;
		
		//Loop used to perform the addition of the 
		//two binary arrays.
		for (int i = 0; i < MAX_BIT_LENGTH; i++)
		{
			if (binaryValue1[i] == 1 && binaryValue2[i] == 1) 
			{
				if (carryOverBit == true)
					binaryResult[i] = 1;
				else {
					binaryResult[i] = 0;
					carryOverBit = true;
				}
			}
			else if (binaryValue1[i] == 1 || binaryValue2[i] == 1) 
			{
				if (carryOverBit == true)
					binaryResult[i] = 0;
				else
					binaryResult[i] = 1;
			}
			else
			{
				if (carryOverBit == true) 
				{
					binaryResult[i] = 1;
					carryOverBit = false;
				}
				else
					binaryResult[i] = 0;
			}
		}
	}
	
	/*Subtracts both the binary arrays and stores said value in the binary
	result array.*/
	protected void subtract () 
	{
		//Sets the second binary array to its corresponding negative value.
		setTwosComplement(2);
		add();
	}
	
	/*Given a signed positive integer and a marker to the desired binary
	array to be set, the corresponding array is given the value of
	the integer in binary.*/
	protected void setPositiveBinaryValue(int signedInt, int binaryValueMarker) 
	{
		
		//Sets temporary array
		int [] tempBinaryArray = setTempBinaryArray(binaryValueMarker);
		
		//Loop used to set binary value of array.
		do {
			if (signedInt >= 64)
			{
				tempBinaryArray[6] = 1;
				signedInt = signedInt - 64;
			}
			else if (signedInt >= 32)
			{
				tempBinaryArray[5] = 1;
				signedInt = signedInt - 32;
			}
			else if (signedInt >= 16)
			{
				tempBinaryArray[4] = 1;
				signedInt = signedInt - 16;
			}
			else if (signedInt >= 8)
			{
				tempBinaryArray[3] = 1;
				signedInt = signedInt - 8;
			}
			else if (signedInt >= 4)
			{
				tempBinaryArray[2] = 1;
				signedInt = signedInt - 4;
			}
			else if (signedInt >= 2)
			{
				tempBinaryArray[1] = 1;
				signedInt = signedInt - 2;
			}
			else if (signedInt >= 1)
			{
				tempBinaryArray[0] = 1;
				signedInt = signedInt - 1;
			}
			
		} while (signedInt != 0);
	}
	
	/*Given a binary array marker, the signed integer value of the array
	is calculated and returned.*/
	protected int getBinaryValue (int binaryValueMarker) 
	{
		//Sets temporary array
		int [] tempBinaryArray = setTempBinaryArray(binaryValueMarker);
		//Decimal value to be returned.
		int totalDecimalValue;
		//Represents position on the binary array and its
		//corresponding value.
		int incrementalValue = 1;
		
		//If the binary array is positive the decimal
		//value is initially set to 0.
		if (tempBinaryArray[MAX_BIT_LENGTH - 1] == 0) 
			totalDecimalValue = 0;
		//If the binary array is negative the decimal
		//value is initially set to -128.
		else 
			totalDecimalValue = -128;
		
		//Loop used to accumulate the proper value to
		//the decimal variable.
		for (int i = 0; i < MAX_BIT_LENGTH - 1; i++) 
		{
			if (tempBinaryArray[i] == 1) 
				totalDecimalValue += incrementalValue;
			
			incrementalValue *= 2;
		}
		
		return totalDecimalValue;
	}
	
	/*Given a binary array marker, the specified array is converted over
	to its two complement.*/
	private void setTwosComplement(int binaryValueMarker) 
	{
		//Boolean used to keep track of the first one in the binary array.
		boolean oneFound = false;
		//Variable used to keep track of the position on the array.
		int arrayPosition = 0;
		
		//Sets temporary array
		int [] tempBinaryArray = setTempBinaryArray(binaryValueMarker);
		
		//Loop used to locate the first one. If no one is found the loop
		//ends just before it reaches the MSB.
		do 
		{
			if (tempBinaryArray[arrayPosition] == 1) 
			{
				arrayPosition++;
				oneFound = true;
			}
			else
				arrayPosition++;
			
		} while (arrayPosition < (MAX_BIT_LENGTH - 1) && oneFound == false);
		
		//If a one is found, all remaining 1s and 0s are inverted.
		if (oneFound == true) {
			for (int i = arrayPosition; i < MAX_BIT_LENGTH; i++) 
			{
				if (tempBinaryArray[i] == 0) 
					tempBinaryArray[i] = 1;
				else
					tempBinaryArray[i] = 0;
			}
		}
	}
	
	/*Given a signed negative integer and a marker to the desired binary
	array to be set, the corresponding array is given the value of
	the integer in binary.*/
	protected void setNegativeBinaryValue(int signedInt, int binaryValueMarker) 
	{
		//Sets temporary array
		int [] tempBinaryArray = setTempBinaryArray(binaryValueMarker);
		
		//The absolute value for the negative integer is found
		//so a positive conversion can be made.
		signedInt = java.lang.Math.abs(signedInt);
		
		//Since 128 can not be represented in the 8 bit range
		//The value for -128 is done automatically.
		if (signedInt == 128) 
		{
			tempBinaryArray[MAX_BIT_LENGTH - 1] = 1;
		}
		//The positive value of the signed integer is assigned
		//and then is converted to its two complement form.
		else 
		{
		setPositiveBinaryValue(signedInt, binaryValueMarker);
		setTwosComplement(binaryValueMarker);
		}
	}
	
	/*Helper method used to set the value of a temporary
	array to the value of the corresponding binary array.
	(1 = binaryValue1, 2 = binaryValue2, and 3 = binaryResult.)*/
	private int[] setTempBinaryArray(int binaryValueMarker) 
	{
		switch (binaryValueMarker) 
		{
			case 1:
				return binaryValue1;
			case 2:
				return binaryValue2;
			case 3:
				return binaryResult;
			default: 
				return null;
		}
	}
	
	/*Method used to properly format the binary value into a 
	string to display. A space is placed after every nibble to make
	it easier to read.*/
	protected String printBinaryValue (int binaryValueMarker) 
	{
		//String being returned.
		String binaryString = "";
		//Value of all array's length.
		int arrayPosition = MAX_BIT_LENGTH - 1;
		//Sets temporary array
		int [] tempBinaryArray = setTempBinaryArray(binaryValueMarker);
		
		//Loop used to set the returned string, a space is added
		//after a nibble.
		for (int i = 0; i < 2; i++) 
		{
			for (int j = 0; j < 4; j++) 
			{
				binaryString = binaryString +
						tempBinaryArray[arrayPosition];
				arrayPosition--;
			}
			binaryString = binaryString + " ";
		}
		
		//String is properly returned.
		return binaryString;
	}
	
}

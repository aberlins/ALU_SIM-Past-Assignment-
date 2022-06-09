package GUI;
//*************************************************************************************//
// Font used for the GUI of the application.
//*************************************************************************************//
import java.awt.Color;
import java.awt.Font;

public class ProgramFont extends Font {

	private static final int RED = 74;
	private static final int GREEN = 211;
	private static final int BLUE = 125;
	private static final int GRAY_VALUE_RGB = 95;
	private static final int REG_RED = 50;
	private static final int REG_GREEN = 125;
	private static final int REG_BLUE = 100;
	public static final Color FONT_COLOR = new Color(RED,GREEN,BLUE);
	public static final Color REGISTER_FONT_COLOR = new Color(REG_RED, REG_GREEN, REG_BLUE);
	public static final Color OPBUTTON_FONT_COLOR = new Color(GRAY_VALUE_RGB, 
			GRAY_VALUE_RGB, GRAY_VALUE_RGB);
	
	public ProgramFont(int style, int size) 
	{
		this("Consolas", style, size);
	}
	
	private ProgramFont(String name, int style, int size) 
	{
		super(name, style, size);
	}

	

}

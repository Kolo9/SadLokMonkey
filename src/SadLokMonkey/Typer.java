package SadLokMonkey;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Typer {

	private Robot robot;
	
	public Typer (Robot robot) {
		this.robot = robot;
	}
	
	public void type(String characters) {
		if (characters.isEmpty()) {
			characters = " ";
		}
		StringSelection stringSelection = new StringSelection(characters);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
		//robot.keyPress(KeyEvent.VK_Y);
		//robot.keyRelease(KeyEvent.VK_Y);

		// For Discord
		robot.delay(2000);
		
		robot.delay(20);
		/*
		int length = characters.length();
		for (int i = 0; i < length; i++) {
			char character = characters.charAt(i);
			type(character);
		}
		*/
		robot.keyPress(KeyEvent.VK_CONTROL);
		//robot.delay(10);
		robot.keyPress(KeyEvent.VK_V);
		//robot.delay(10);
		robot.keyRelease(KeyEvent.VK_V);
		//robot.delay(10);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//robot.delay(10);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}



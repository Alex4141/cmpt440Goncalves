import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Application {

	public static void main(String[] args){
		TerminalUI i = new TerminalUI();
		i.setVisible(true);
	}
}

/*
* This is the class to set up the Terminal's appearance
* as well as some minor functionalities.
*/

class TerminalUI extends javax.swing.JFrame implements KeyListener{
	public final StringBuffer CHAR_BUFFER = new StringBuffer();
	
	public TerminalUI(){
		this.setup();
	}

	/*
	* Sets up the TextArea and some other 
	* characteristics regarding the content
	*/
	public void setup(){
		// Window Properties
		this.setTitle("Red Fox Shell");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TextArea Properties
		JTextArea tArea = new JTextArea(15, 50);
		tArea.addKeyListener(this);
		tArea.setBackground(new Color(0,0,0));
		tArea.setFont(new Font("Monospace", Font.PLAIN, 15));
		tArea.setForeground(Color.WHITE);
		
		this.add(tArea);
		this.pack();
	}

	/*
	* Method is only here because it's required
	* by the interface
	*/

	public void keyTyped(KeyEvent e){
	}

	/*
	* Method implemented from the KeyListener interface
	* defines behaviours for certain keys.
	*/

	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		//Arrow Keys disabled
		switch(keyCode){
			case KeyEvent.VK_UP:
				e.consume();
				break;
			case KeyEvent.VK_DOWN:
				e.consume();
				break;
			case KeyEvent.VK_LEFT:
				e.consume();
				break;
			case KeyEvent.VK_RIGHT:
				e.consume();
				break;
			case KeyEvent.VK_BACK_SPACE:
				if(CHAR_BUFFER.length() == 0){
					e.consume();
				} else {
					CHAR_BUFFER.delete(CHAR_BUFFER.length()-1,CHAR_BUFFER.length());
				}
				break;
			case KeyEvent.VK_ENTER:
				//TODO Add DFA driver as well as implementing new line
				CHAR_BUFFER.delete(0, CHAR_BUFFER.length());
				break;
			default:
				CHAR_BUFFER.append(e.getKeyChar());
		}
	}

	/*
	* Method is only here because it's required
	* by the interface
	*/

	public void keyReleased(KeyEvent e){
	}
}
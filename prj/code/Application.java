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
	public final TerminalDFA dfa = new TerminalDFA();
	final JTextArea tArea =  new JTextArea(15, 50);

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
		tArea.addKeyListener(this);
		tArea.setBackground(new Color(0,0,0));
		tArea.setFont(new Font("Monospace", Font.PLAIN, 15));
		tArea.setForeground(Color.WHITE);

		tArea.append(System.getProperty("user.name")+">");
		tArea.setCaretPosition(tArea.getText().length());

		JScrollPane scrollPane = new JScrollPane(tArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		this.add(scrollPane);
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
			case KeyEvent.VK_SHIFT:
				e.consume();
				break;
			case KeyEvent.VK_ENTER:
				e.consume();
				String input = CHAR_BUFFER.toString();
				String result = dfa.processString(input);
				setUser(result);
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

	public void setUser(String result){
		this.tArea.append("\n" + result);
		this.tArea.append("\n" + System.getProperty("user.name")+">");
		this.tArea.setCaretPosition(tArea.getDocument().getLength());

	}
}
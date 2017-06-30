package src;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Panel extends JPanel{
	public Font bigfont;
	public Font smallfont;
	
	public JTextField inputBox;
	public JButton button;
	public JTextPane bigDisp;
	
	public JTextArea alpha;
	public JTextArea HTML;
	public JTextArea decimal;
	public JTextArea hex;
	public JTextArea java;
	public JTextArea desc;
	
	public JTextArea[] areas;
	
	public Panel(){
		super();
		//set up font
		try {
			FileInputStream in = new FileInputStream("Code200365k.ttf");
			Font UniFont = Font.createFont(Font.TRUETYPE_FONT, in);
			bigfont = UniFont.deriveFont(400F);
			smallfont = UniFont.deriveFont(24F);	
		} catch (FontFormatException|IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Font newfont = new JLabel().getFont();
			bigfont = newfont.deriveFont(400F);
			smallfont = newfont.deriveFont(24F);
		} 
		
		//set up self
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(inputField());
		this.add(bigDisplay());
		this.add(infoPanel());
		
	}
	
	public void clear(){
		bigDisp.setText("");
		alpha.setText("");
		HTML.setText("");
		decimal.setText("");
		hex.setText("");
		java.setText("");
		desc.setText("");
	}
	
	public JPanel inputField(){
		//set up input fields
		JPanel inputField = new JPanel();
		inputField.setLayout(new BoxLayout(inputField, BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel("Paste your Character here:");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel box = new JPanel();
		inputBox = new JTextField(2);
		inputBox.setFont(smallfont);
		inputBox.setHorizontalAlignment(JTextField.CENTER);
		box.add(inputBox);
		
		button = new JButton("See Character Info");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		inputField.add(label);
		inputField.add(box);
		inputField.add(button);
		
		return inputField;
	}
	
	public JScrollPane bigDisplay(){
		bigDisp = new JTextPane();
		
		JPanel bigDisplay = new JPanel();
		bigDisplay.setLayout(new BoxLayout(bigDisplay, BoxLayout.PAGE_AXIS));
		
		JLabel label = new JLabel("Big Display");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		StyledDocument doc = bigDisp.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		bigDisp.setEditable(false);
		bigDisp.setFont(bigfont);
		
		bigDisplay.add(label);
		bigDisplay.add(bigDisp);
		
		return new JScrollPane(bigDisplay);
	}
	
	public JPanel infoPanel(){
		//set up info panel
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
		JTextArea[] areas_arr={alpha,HTML,decimal,hex,java,desc};
		areas=areas_arr;
		String[] subpanel_name={"Alpha Entity","HTML Decimal Entity","Decimal","Hex","Java Character Code","Character Description"};
		for (int i=0; i<subpanel_name.length ;i++){
			areas[i]=new JTextArea(5,7);
			infoPanel.add(new JScrollPane(subpanel(subpanel_name[i],areas[i])));
		}
		
		return infoPanel;
	}
	
	public JPanel subpanel(String name, JTextArea area){
		//pass area reference
		JPanel subpanel=new JPanel();
		subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.PAGE_AXIS));
		JLabel label = new JLabel(name);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		area.setEditable(false);
		subpanel.add(label);
		subpanel.add(area);
		
		return subpanel;
	}
	
}

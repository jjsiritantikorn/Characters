import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import org.apache.commons.lang3.StringEscapeUtils;


public class Userwindow {


	public static void main(String[] args) {

		
	JPanel inputlabel = new JPanel();
	inputlabel.setLayout(new FlowLayout());
	JLabel inputlabel1 = new JLabel("Paste your character here:"); //Label
	inputlabel.add(inputlabel1);
	

	JPanel inputpanel = new JPanel();
	inputpanel.setLayout(new FlowLayout());
	
	final TextField inputbox = new TextField(5); //Item
	inputpanel.add(inputbox); //Both in 1 JPanel
	inputbox.setText("0");

	/* What I'm essentially doing is making pairs of a JLabel with a JTextArea
	 * These pairs will go into multiple JPanels with a FlowLayout, making the layout automatically organized
	 * These JPanels will then be stacked in another JPanel with a vertical BoxLayout
	 * There are 4 small JPanels here:
	 * 
	 * 1) Input panel (Instruction label + TextField) NOTE: Pressing enter also works along with the button
	 * 2) Button panel (Just a button the user clicks to see the result)
	 * 3) The big display (Description label + big JTextArea with big character)
	 * 4) The info panel (Pairs of JTextAreas showing outputs with labels for each textbox)
	 * 
	 * The big JPanel will go into a main JFrame that will be the app window*/
	
	

	JPanel biglabel = new JPanel();
	biglabel.setLayout(new FlowLayout());
	JLabel biglabel1 = new JLabel("Big display:"); //Label
	biglabel.add(biglabel1);
	
	JPanel bigdisplay = new JPanel();
	final JTextArea bigcharacter = new JTextArea(2,2); //Item
	bigcharacter.setEditable(false);

	Font font = new Font("OpenSansEmoji", Font.PLAIN, 100); //(Early attempt at showing emojis in this box)
	bigcharacter.setFont(font);
	bigcharacter.setText("0");
	bigdisplay.add(new JScrollPane(bigcharacter)); //Both in a JPanel

	
	
	
	
	
	
	JPanel infopanel = new JPanel();
	infopanel.setLayout(new FlowLayout());
	
	JPanel Alpha = new JPanel();
	Alpha.setLayout(new BoxLayout(Alpha, BoxLayout.PAGE_AXIS));
	JLabel alphalabel = new JLabel("Alpha entity:");			//Label
	final JTextArea alpha = new JTextArea(5,7);					//Item
	alpha.setEditable(false);
	alpha.setText("n/a");
	Alpha.add(alphalabel);										//Both in a JPanel
	Alpha.add(alpha);
	infopanel.add(new JScrollPane(Alpha));						//Put JPanel in JPanel
	
	/* I have tried many times to turn these chunks into one method e.g. makeBox("Alpha entity:", "n/a")
	 * It's very repetitive but I couldn't find a way */
	
	
	JPanel HTML = new JPanel();
	HTML.setLayout(new BoxLayout(HTML, BoxLayout.PAGE_AXIS));	//For HTML Entity Number
	JLabel declabel = new JLabel("HTML Decimal entity:");
	final JTextArea htmlnumber = new JTextArea(5,7);
	htmlnumber.setEditable(false);
	htmlnumber.setText("&#48");
	HTML.add(declabel);
	HTML.add(htmlnumber);
	infopanel.add(new JScrollPane(HTML));
	
	
	
	JPanel Decimal = new JPanel();
	Decimal.setLayout(new BoxLayout(Decimal, BoxLayout.PAGE_AXIS));
	JLabel numlabel = new JLabel("Decimal:");
	final JTextArea dectext = new JTextArea(5,7);				//For Decimal entity
	dectext.setEditable(false);
	dectext.setText("48");
	Decimal.add(numlabel);
	Decimal.add(dectext);
	infopanel.add(new JScrollPane(Decimal));
	
	
	
	JPanel Javacode = new JPanel();
	Javacode.setLayout(new BoxLayout(Javacode, BoxLayout.PAGE_AXIS));	//For Java character code
	JLabel javalabel = new JLabel("Java character code:");
	final JTextArea javatext = new JTextArea(5,7);
	javatext.setEditable(false);
	javatext.setText("0");
	Javacode.add(javalabel);
	Javacode.add(javatext);
	infopanel.add(new JScrollPane(Javacode));
	
	
	
	JPanel Hexpanel = new JPanel();
	Hexpanel.setLayout(new BoxLayout(Hexpanel, BoxLayout.PAGE_AXIS)); //For Hexadecimal entity
	JLabel hexlabel = new JLabel("Hex decimal:");
	final JTextArea Hexnum = new JTextArea(5,7);
	Hexnum.setEditable(false);
	Hexnum.setText("30");
	Hexpanel.add(hexlabel);
	Hexpanel.add(Hexnum);
	infopanel.add(new JScrollPane(Hexpanel));
	
	
	
	JPanel chardespanel = new JPanel();
	chardespanel.setLayout(new BoxLayout(chardespanel, BoxLayout.PAGE_AXIS)); //For character description
	JLabel charlabel = new JLabel("Character description:");
	final JTextArea characterdescription = new JTextArea(5,7);				//The challenge now is to connect this to CSV file
	characterdescription.setEditable(false);
	characterdescription.setText("From CSV File");
	chardespanel.add(charlabel);
	chardespanel.add(characterdescription);
	infopanel.add(new JScrollPane(chardespanel));
	
	JPanel Unicode = new JPanel();
	Unicode.setLayout(new BoxLayout(Unicode, BoxLayout.PAGE_AXIS)); //For Unicode - I am still researching
	JLabel unilabel = new JLabel("Unicode");
	final JTextArea unicode = new JTextArea(5,7);
	unicode.setEditable(false);
	unicode.setText("Unicode");
	Unicode.add(unilabel);
	Unicode.add(unicode);
	infopanel.add(new JScrollPane(Unicode));
	
	
	JPanel seebutton = new JPanel();
	seebutton.setLayout(new FlowLayout());

	
	
	
	JButton seeresult = new JButton("See information");			//Button
	
    seeresult.addActionListener(new ActionListener() {
      	 
		public void actionPerformed(ActionEvent e){
			
			 if(inputbox.getText().equals("")) {
				bigcharacter.setText("");
				alpha.setText("");
				htmlnumber.setText("");					//If the input is empty then erase previous results to show null
				javatext.setText("");
				Hexnum.setText("");
				characterdescription.setText("");
				dectext.setText("");
			}
			 else{
			
			String input = inputbox.getText();		//Gets the input
			
			
			bigcharacter.setText(input);			//Since 'bigcharacter' already has a defined big font I just pasted in there

	

			char inputchar = input.charAt(0);
			
			int inputnum = inputchar;				//Turns the char into a decimal
			
			
			String inputnum1 = Integer.toString(inputnum);
			String inputentnum = "&#";
			inputentnum = inputentnum.concat(inputnum1);		//Turned integer to string to add &# then add to outputbox
			
			
			
			htmlnumber.setText(inputentnum);
			
			
			String Javacode = StringEscapeUtils.escapeJava(input); //This package from Apache is very useful
			
			/* I need to find a different way though because inputting '@' or '(' etc, which are symbols in java already,
			 * doesn't return a /u result as it should*/
			
			
			javatext.setText(Javacode);
			
			
			
			
			String Alphaentity = StringEscapeUtils.escapeHtml4(input);
			
			
			
			
			
			if (Alphaentity.equals(input)){
				alpha.setText("n/a");
			} else {
			
			alpha.setText(Alphaentity);
			
			}
			
			/* This method from Apache returns the same character if there is no HTML entity name
			 * like &amp, so I took care of that*/
			
			
			dectext.setText(inputnum1); //Decimal entity
			
			
			
			
						
			String hex = Integer.toHexString(inputnum); //Converts decimal to hex
			
			Hexnum.setText(hex);
			 }
		}
	});

    seebutton.add(seeresult);

	
	/* The code below is another part I would like to turn into a method if possible. It's the exact same as above,
	 * except it listens to the enter key instead of the user clicking the button */
    

    inputbox.addActionListener(new ActionListener() {
   	 
		public void actionPerformed(ActionEvent e){
			
			 if(inputbox.getText().equals("")) {
				bigcharacter.setText("");
				alpha.setText("");
				htmlnumber.setText("");
				javatext.setText("");
				Hexnum.setText("");
				characterdescription.setText("");
				dectext.setText("");
			}
			 else{
			
			 

			String input = inputbox.getText();
			
			bigcharacter.setText(input); 
	

			char inputchar = input.charAt(0);
			int inputnum = inputchar;
			String inputnum1 = Integer.toString(inputnum);
			String inputentnum = "&#";
			inputentnum = inputentnum.concat(inputnum1);
			
			htmlnumber.setText(inputentnum);
			
			String Javacode = StringEscapeUtils.escapeJava(input);
			javatext.setText(Javacode);
			
			String Alphaentity = StringEscapeUtils.escapeHtml4(input);
			
			if (Alphaentity.equals(input)){
				alpha.setText("n/a");
			} else {
			
			alpha.setText(Alphaentity);
			
			}
			
			
			dectext.setText(inputnum1);
						
			String hex = Integer.toHexString(inputnum);
			
			Hexnum.setText(hex);
			 }
		}
	});
    
    
    
    
	JPanel mainframe = new JPanel();
	mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
	
	
	mainframe.add(inputlabel);
	mainframe.add(inputpanel);				//Puts all those JPanels in this new one
	mainframe.add(seebutton);
	mainframe.add(biglabel);
	mainframe.add(bigdisplay);
	mainframe.add(infopanel);
	
	JFrame mainmainframe = new JFrame(); 	//Puts the JPanel in a JFrame which can then be shown to the user
	
	
	mainmainframe.add(mainframe);
	mainmainframe.pack();
    mainmainframe.setVisible(true);
	
}
}
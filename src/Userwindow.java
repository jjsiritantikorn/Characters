import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringEscapeUtils;


public class Userwindow {


	public static void main(String[] args) {

		
	JPanel inputlabel = new JPanel();
	inputlabel.setLayout(new FlowLayout());
	JLabel inputlabel1 = new JLabel("Paste your character here:");
	inputlabel.add(inputlabel1);
	

	JPanel inputpanel = new JPanel();
	inputpanel.setLayout(new FlowLayout());
	
	final JTextField inputbox = new JTextField(5); //What I'm doing is making a JLabel paired with its JTextArea
	inputpanel.add(inputbox);
	inputbox.setText("0");

	
	
	

	JPanel biglabel = new JPanel();
	biglabel.setLayout(new FlowLayout());
	JLabel biglabel1 = new JLabel("Big display:");
	biglabel.add(biglabel1);
	
	JPanel bigdisplay = new JPanel();
	final JTextArea bigcharacter = new JTextArea(2,2);
	bigcharacter.setEditable(false);

	Font font = new Font(inputbox.getName(), Font.PLAIN, 100);
	bigcharacter.setFont(font);
	bigcharacter.setText("0");
	bigdisplay.add(new JScrollPane(bigcharacter));

	
	
	
	
	
	
	JPanel infopanel = new JPanel();
	infopanel.setLayout(new FlowLayout());
	
	JPanel Alpha = new JPanel();
	Alpha.setLayout(new BoxLayout(Alpha, BoxLayout.PAGE_AXIS));
	JLabel alphalabel = new JLabel("Alpha entity:");
	final JTextArea alpha = new JTextArea(5,7);
	alpha.setEditable(false);
	alpha.setText("n/a");
	Alpha.add(alphalabel);
	Alpha.add(alpha);
	infopanel.add(new JScrollPane(Alpha));
	
	
	
	JPanel HTML = new JPanel();
	HTML.setLayout(new BoxLayout(HTML, BoxLayout.PAGE_AXIS));
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
	final JTextArea dectext = new JTextArea(5,7);
	dectext.setEditable(false);
	dectext.setText("48");
	Decimal.add(numlabel);
	Decimal.add(dectext);
	infopanel.add(new JScrollPane(Decimal));
	
	
	
	JPanel Javacode = new JPanel();
	Javacode.setLayout(new BoxLayout(Javacode, BoxLayout.PAGE_AXIS));
	JLabel javalabel = new JLabel("Java character code:");
	final JTextArea javatext = new JTextArea(5,7);
	javatext.setEditable(false);
	javatext.setText("0");
	Javacode.add(javalabel);
	Javacode.add(javatext);
	infopanel.add(new JScrollPane(Javacode));
	
	
	
	JPanel Hexpanel = new JPanel();
	Hexpanel.setLayout(new BoxLayout(Hexpanel, BoxLayout.PAGE_AXIS));
	JLabel hexlabel = new JLabel("Hex decimal:");
	final JTextArea Hexnum = new JTextArea(5,7);
	Hexnum.setEditable(false);
	Hexnum.setText("30");
	Hexpanel.add(hexlabel);
	Hexpanel.add(Hexnum);
	infopanel.add(new JScrollPane(Hexpanel));
	
	
	
	JPanel chardespanel = new JPanel();
	chardespanel.setLayout(new BoxLayout(chardespanel, BoxLayout.PAGE_AXIS));
	JLabel charlabel = new JLabel("Character description:");
	final JTextArea characterdescription = new JTextArea(5,7);
	characterdescription.setEditable(false);
	characterdescription.setText("From CSV File");
	chardespanel.add(charlabel);
	chardespanel.add(characterdescription);
	infopanel.add(new JScrollPane(chardespanel));
	
	JPanel Unicode = new JPanel();
	Unicode.setLayout(new BoxLayout(Unicode, BoxLayout.PAGE_AXIS));
	JLabel unilabel = new JLabel("Unicode");
	final JTextArea unicode = new JTextArea(5,7);
	unicode.setEditable(false);
	unicode.setText("Unicode");
	Unicode.add(unilabel);
	Unicode.add(unicode);
	infopanel.add(new JScrollPane(Unicode));
	
	
	JPanel seebutton = new JPanel();
	seebutton.setLayout(new FlowLayout());

	
	
	
	JButton seeresult = new JButton("See information");
	
    seeresult.addActionListener(new ActionListener() {
      	 
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

    seebutton.add(seeresult);

	
	
    

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
	
	JFrame mainmainframe = new JFrame();
	
	
	mainframe.add(inputlabel);
	mainframe.add(inputpanel);
	mainframe.add(seebutton);
	mainframe.add(biglabel);
	mainframe.add(bigdisplay);
	mainframe.add(infopanel);
	
	mainmainframe.add(mainframe);
	mainmainframe.pack();
    mainmainframe.setVisible(true);
	
}
}
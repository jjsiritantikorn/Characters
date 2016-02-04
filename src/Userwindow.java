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
	JLabel inputlabel1 = new JLabel("Paste your character here:"); //Instructions for input box
	inputlabel.add(inputlabel1);	
	
	
	
	
	JPanel inputpanel = new JPanel();
	inputpanel.setLayout(new FlowLayout());
	
	final JTextField inputbox = new JTextField(5); //Input box for user
	inputpanel.add(inputbox);
	inputbox.setText("0");
	
	
	

	JPanel biglabel = new JPanel();
	biglabel.setLayout(new FlowLayout());
	JLabel biglabel1 = new JLabel("Big display:"); //Label for big display box
	biglabel.add(biglabel1);
	
	JPanel bigdisplay = new JPanel();
	final JTextArea bigcharacter = new JTextArea(2,2);
	bigcharacter.setEditable(false);

	Font font = new Font(inputbox.getName(), Font.PLAIN, 100); //Displays user's character in same font but larger size
	bigcharacter.setFont(font);
	bigdisplay.add(new JScrollPane(bigcharacter));

	
	
	
	
	
	
	JPanel infopanel = new JPanel();
	infopanel.setLayout(new FlowLayout());
	
	final JTextArea htmlnumber = new JTextArea(5,15);
	htmlnumber.setEditable(false);
	htmlnumber.append("HTML Entity Number:\n");
	
	
	
	
	final JTextArea entities = new JTextArea(5,15);
	entities.setEditable(false);
	entities.append("hex/unicode");
	
	final JTextArea javacode = new JTextArea(5,15);				//Text boxes for required information
	javacode.setEditable(false);
	javacode.append("How to code in java");
	
	JTextArea UTF8info = new JTextArea(5,15);
	UTF8info.setEditable(false);
	UTF8info.append("UTF8 info");
	
	JTextArea characterdescription = new JTextArea(5,15);
	characterdescription.setEditable(false);
	characterdescription.append("description of character");
	
	infopanel.add(new JScrollPane(htmlnumber));
	infopanel.add(new JScrollPane(entities));
	infopanel.add(new JScrollPane(javacode));
	infopanel.add(new JScrollPane(UTF8info));
	infopanel.add(new JScrollPane(characterdescription));
	
	
	JPanel seebutton = new JPanel();
	seebutton.setLayout(new FlowLayout());
	
	
	
	
	JButton seeresult = new JButton("See information");
	
	seeresult.addActionListener(new ActionListener() {		//Button to display information
	    	 
		public void actionPerformed(ActionEvent e){
			
			String show = inputbox.getText();				//For big character display
			bigcharacter.setText(show); 

			

			String input = inputbox.getText();
			char inputchar = input.charAt(0);				//Finds and prints html entity number
			int inputnum = inputchar;
			String inputnum1 = Integer.toString(inputnum);
			String inputentnum = "&#";
			inputentnum = inputentnum.concat(inputnum1);
			
			htmlnumber.setText("HTML Entity Number:\n" + inputentnum);
			
			String Javacode = StringEscapeUtils.escapeJava(input); //Finds and prints Java character code
			javacode.setText("Java character code: " + Javacode);
		}
	});

    seebutton.add(seeresult);
	
	
	JPanel mainframe = new JPanel();
	mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
	
	JFrame mainmainframe = new JFrame();
	
	
	mainframe.add(inputlabel);
	mainframe.add(inputpanel);
	mainframe.add(seebutton);					//Displays app window
	mainframe.add(biglabel);
	mainframe.add(bigdisplay);
	mainframe.add(infopanel);
	
	mainmainframe.add(mainframe);
	mainmainframe.pack();
    mainmainframe.setVisible(true);
	
}
}


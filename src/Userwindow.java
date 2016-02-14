package src;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Userwindow {


	public static void main(String[] args) throws ClassNotFoundException {

		
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
	final TextArea bigcharacter = new TextArea(2,2); //Item
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
	characterdescription.setText("n/a");
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
      	 
		private Scanner inputStream;

		public void actionPerformed(ActionEvent e){
			
			//Initial value of the outputs
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
			
			//Sets big character
			bigcharacter.setText(input);			//Since 'bigcharacter' already has a defined big font I just pasted in there

			//Sets the decimal entity
			int inputnum = input.codePointAt(0);				//Turns the char into a decimal
			String inputnum1 = Integer.toString(inputnum);
			dectext.setText(inputnum1); //Decimal entity
			
			//Sets html decimal entity
			String inputentnum = "&#";
			inputentnum = inputentnum.concat(inputnum1);		//Turned integer to string to add &# then add to outputbox
			htmlnumber.setText(inputentnum);
			
			//Sets hex			
			String hex = Integer.toHexString(inputnum); //Converts decimal to hex
			String hex1 = new String();
			if (inputnum < 16){
				hex1="000"+hex;
			} else if (inputnum < 256){
				hex1="00"+hex;
			} else if (inputnum < 4096){
				hex1="0"+hex;
			} else {
				hex1=hex;
			} 
			Hexnum.setText("0x"+hex1);
			
			//Sets Java Code
			String hex2 = hex1.toUpperCase();			
			if (inputnum < 65536){
				javatext.setText("\\u"+hex2);
			} else{
				
				//Subtracts 0x10000(=65536) from the code point and converts to a binary string, then split it into an array of strings
				String binstr= Integer.toBinaryString(inputnum-65536);
				String[] bindec = binstr.split("");
				int length = bindec.length;
				
				//Sets up the initial high surrogate string and low surrogate string
				String highsuri = new String();
				String lowsuri = new String();
				
				//Joins the first to the tenth last elements to get the initial high surrogate string
				for (int i=0;i<(length-10);i++){
					highsuri+=bindec[i];
				}
				
				//Joins last ten elements to get the initial high surrogate string
				for (int i=(length-10);i<length;i++){
					lowsuri+=bindec[i];
				}
				
				//Converts both to integer for further operation
				int highsur = Integer.parseInt(highsuri,2);
				int lowsur = Integer.parseInt(lowsuri,2);
				
				//Adds 0xD800(=55296) to the high surrogate and 0xDc00(=56320) to the low surrogate
				highsur+=55296;
				lowsur+=56320;
				
				//convert both to final hex string
				String highsurf=Integer.toHexString(highsur);
				String lowsurf=Integer.toHexString(lowsur);
				
				//convert both to upper case
				String highsurfu = highsurf.toUpperCase();
				String lowsurfu = lowsurf.toUpperCase();
				
				//Set java code
				javatext.setText("\\u"+highsurfu+"\\u"+lowsurfu);
			}
			
			//imports entityfacts.csv and sets alpha entity and symbol description
			characterdescription.setText("n/a");	//set initial values
			alpha.setText("n/a");	
			String filename = "entityfacts.csv";
			File file = new File(filename);//creates new object file
			try {
				inputStream = new Scanner(file);//scans the file
				for (int i=1; i<9; i++) {
					inputStream.nextLine();//skips the first 9 lines, which are not data
				}
				while (inputStream.hasNextLine()){
					String data = inputStream.nextLine();//stores the next line in the string "data"
					String[] values = data.split(",");//splits "data" by "," into an array of strings "values[]"
					String[] valuesn = new String[values.length];
					for (int i = 0; i < values.length; i++) {
					    valuesn[i] = values[i].trim();//trims the spaces in front of the "values[]" and stores them in a new array of strings "values[]"
					}
					int hexfile = Integer.decode(valuesn[1]);//Turns the second column, which represents the hex, into integer.
					if (inputnum==hexfile) {	//if the character decimal entity equals the resulting integer
						characterdescription.setText(valuesn[4]);	//then set the description to the fifth column
						alpha.setText(valuesn[3]);	//set the alpha entity to the fourth column
						break;						
					} else {
						continue;
					}
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//imports unicodeindex.csv and sets additional symbol description
			String filename2 = "unicodeindex.csv";
			File file2 = new File(filename2);//creates new object file
			try {
				inputStream = new Scanner(file2);//scans the file
				while (inputStream.hasNextLine()){
					String data2 = inputStream.nextLine();//stores the next line in the string "data"
					String[] values2 = data2.split(",");//splits "data" by "," into an array of strings "values[]
					int hexfile2 = Integer.decode("0x"+values2[1]);
					if(inputnum==hexfile2){
						characterdescription.setText(values2[0]);
						break;
					} else{
						continue;						
					}
					}
				}
			 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//imports emoji.csv and sets additional symbol description
			String filename3 = "emoji.csv";
			File file3 = new File(filename3);//creates new object file
			try {
				inputStream = new Scanner(file3);//scans the file
				while (inputStream.hasNextLine()){
					String data3 = inputStream.nextLine();//stores the next line in the string "data"
					String[] values3 = data3.split(",");//splits "data" by "," into an array of strings "values[]
					int hexfile3 = Integer.decode("0x"+values3[1]);
					if(inputnum==hexfile3){
						characterdescription.setText(values3[0]);
						break;
					} else{
						continue;						
					}
					}
				}
			 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 }
		}
	});

    seebutton.add(seeresult);

	
	/* The code below is another part I would like to turn into a method if possible. It's the exact same as above,
	 * except it listens to the enter key instead of the user clicking the button */
    

    inputbox.addActionListener(new ActionListener() {
     	 
		private Scanner inputStream;

		public void actionPerformed(ActionEvent e){
			
			//Initial value of the outputs
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
			
			//Sets big character
			bigcharacter.setText(input);			//Since 'bigcharacter' already has a defined big font I just pasted in there

			//Sets the decimal entity
			int inputnum = input.codePointAt(0);				//Turns the char into a decimal
			String inputnum1 = Integer.toString(inputnum);
			dectext.setText(inputnum1); //Decimal entity
			
			//Sets html decimal entity
			String inputentnum = "&#";
			inputentnum = inputentnum.concat(inputnum1);		//Turned integer to string to add &# then add to outputbox
			htmlnumber.setText(inputentnum);
			
			//Sets hex			
			String hex = Integer.toHexString(inputnum); //Converts decimal to hex
			String hex1 = new String();
			if (inputnum < 16){
				hex1="000"+hex;
			} else if (inputnum < 256){
				hex1="00"+hex;
			} else if (inputnum < 4096){
				hex1="0"+hex;
			} else {
				hex1=hex;
			} 
			Hexnum.setText("0x"+hex1);
			
			//Sets Java Code
			String hex2 = hex1.toUpperCase();			
			if (inputnum < 65536){
				javatext.setText("\\u"+hex2);
			} else{
				
				//Subtracts 0x10000(=65536) from the code point and converts to a binary string, then split it into an array of strings
				String binstr= Integer.toBinaryString(inputnum-65536);
				String[] bindec = binstr.split("");
				int length = bindec.length;
				
				//Sets up the initial high surrogate string and low surrogate string
				String highsuri = new String();
				String lowsuri = new String();
				
				//Joins the first to the tenth last elements to get the initial high surrogate string
				for (int i=0;i<(length-10);i++){
					highsuri+=bindec[i];
				}
				
				//Joins last ten elements to get the initial high surrogate string
				for (int i=(length-10);i<length;i++){
					lowsuri+=bindec[i];
				}
				
				//Converts both to integer for further operation
				int highsur = Integer.parseInt(highsuri,2);
				int lowsur = Integer.parseInt(lowsuri,2);
				
				//Adds 0xD800(=55296) to the high surrogate and 0xDc00(=56320) to the low surrogate
				highsur+=55296;
				lowsur+=56320;
				
				//convert both to final hex string
				String highsurf=Integer.toHexString(highsur);
				String lowsurf=Integer.toHexString(lowsur);
				
				//convert both to upper case
				String highsurfu = highsurf.toUpperCase();
				String lowsurfu = lowsurf.toUpperCase();
				
				//Set java code
				javatext.setText("\\u"+highsurfu+"\\u"+lowsurfu);
			}
			
			//imports entityfacts.csv and sets alpha entity and symbol description
			characterdescription.setText("n/a");	//set initial values
			alpha.setText("n/a");	
			String filename = "entityfacts.csv";
			File file = new File(filename);//creates new object file
			try {
				inputStream = new Scanner(file);//scans the file
				for (int i=1; i<9; i++) {
					inputStream.nextLine();//skips the first 9 lines, which are not data
				}
				while (inputStream.hasNextLine()){
					String data = inputStream.nextLine();//stores the next line in the string "data"
					String[] values = data.split(",");//splits "data" by "," into an array of strings "values[]"
					String[] valuesn = new String[values.length];
					for (int i = 0; i < values.length; i++) {
					    valuesn[i] = values[i].trim();//trims the spaces in front of the "values[]" and stores them in a new array of strings "values[]"
					}
					int hexfile = Integer.decode(valuesn[1]);//Turns the second column, which represents the hex, into integer.
					if (inputnum==hexfile) {	//if the character decimal entity equals the resulting integer
						characterdescription.setText(valuesn[4]);	//then set the description to the fifth column
						alpha.setText(valuesn[3]);	//set the alpha entity to the fourth column
						break;						
					} else {
						continue;
					}
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//imports unicodeindex.csv and sets additional symbol description
			String filename2 = "unicodeindex.csv";
			File file2 = new File(filename2);//creates new object file
			try {
				inputStream = new Scanner(file2);//scans the file
				while (inputStream.hasNextLine()){
					String data2 = inputStream.nextLine();//stores the next line in the string "data"
					String[] values2 = data2.split(",");//splits "data" by "," into an array of strings "values[]
					int hexfile2 = Integer.decode("0x"+values2[1]);
					if(inputnum==hexfile2){
						characterdescription.setText(values2[0]);
						break;
					} else{
						continue;						
					}
					}
				}
			 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//imports emoji.csv and sets additional symbol description
			String filename3 = "emoji.csv";
			File file3 = new File(filename3);//creates new object file
			try {
				inputStream = new Scanner(file3);//scans the file
				while (inputStream.hasNextLine()){
					String data3 = inputStream.nextLine();//stores the next line in the string "data"
					String[] values3 = data3.split(",");//splits "data" by "," into an array of strings "values[]
					int hexfile3 = Integer.decode("0x"+values3[1]);
					if(inputnum==hexfile3){
						characterdescription.setText(values3[0]);
						break;
					} else{
						continue;						
					}
					}
				}
			 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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

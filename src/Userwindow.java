import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Userwindow {
	
	public static void main(String[] args) {

	
	JPanel inputpanel = new JPanel();
	inputpanel.setLayout(new FlowLayout());
		
	final JTextArea inputbox = new JTextArea(5,5);
	inputbox.append("User input goes here");
	inputpanel.add(inputbox);

	
	
	JPanel bigdisplay = new JPanel();
	final JTextArea bigcharacter = new JTextArea(10,10);
	bigcharacter.setEditable(false);
	
	Font font = new Font("Arial", Font.PLAIN, 36);
	bigcharacter.append("Large character displayed here");
	bigcharacter.setFont(font);
	bigdisplay.add(bigcharacter);

	
	
	
	
	JPanel infopanel = new JPanel();
	infopanel.setLayout(new FlowLayout());
	
	JTextArea hexunicodenumber = new JTextArea(10,10);
	hexunicodenumber.setEditable(false);
	hexunicodenumber.append("hex/unicode number");
	JTextArea entities = new JTextArea(10,10);
	entities.setEditable(false);
	entities.append("entities info");
	JTextArea javacode = new JTextArea(10,10);
	javacode.setEditable(false);
	javacode.append("how to code in java");
	JTextArea UTF8info = new JTextArea(10,10);
	UTF8info.setEditable(false);
	UTF8info.append("UTF8 info");
	JTextArea characterdescription = new JTextArea(10,10);
	characterdescription.setEditable(false);
	characterdescription.append("description of character");
	
	infopanel.add(hexunicodenumber);
	infopanel.add(entities);
	infopanel.add(javacode);
	infopanel.add(UTF8info);
	infopanel.add(characterdescription);
	
	
	JPanel seebutton = new JPanel();
	seebutton.setLayout(new FlowLayout());
	
	JButton seeresult = new JButton("See information");
    
	
	seeresult.addActionListener(new ActionListener() {
	    	 
		public void actionPerformed(ActionEvent e){
			
			String show = inputbox.getText();
			bigcharacter.setText(show); 
			
		}
	});

    seebutton.add(seeresult);
	
	
	JPanel mainframe = new JPanel();
	mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
	
	JFrame mainmainframe = new JFrame();
	
	
	
	mainframe.add(inputpanel);
	mainframe.add(seebutton);
	mainframe.add(bigdisplay);
	mainframe.add(infopanel);
	
	mainmainframe.add(mainframe);
	mainmainframe.pack();
    mainmainframe.setVisible(true);
	
}
}


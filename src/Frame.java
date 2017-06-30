package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Frame extends JFrame implements ActionListener {
	
	public Converter converter;
	public Panel panel;
	
	public Frame(){
		
		super();
		converter=new Converter();
		panel=new Panel();
		
		panel.button.addActionListener(this);
		
		this.add(panel);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String character=panel.inputBox.getText();
		if (character==""){
			panel.clear();
		}else{
			//set up big character
			panel.bigDisp.setText(character);
			//set up info panel
			String[] fields=converter.fields(character);
			for (int i =0; i<panel.areas.length; i++){
				panel.areas[i].setText(fields[i]);
			}
		}
	}
}

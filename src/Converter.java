package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Converter {
	 
	public Map<String, String> description;
	public Map<String, String> alpha;
	
	public Converter(){		
		
		//set up description and alpha dictionary
		description = new HashMap<String, String>();
		alpha = new HashMap<String, String>();
		
		//set up description dic
		String filename = "description.csv";
		File file = new File(filename);//creates new object file
		try {
			Scanner scanner = new Scanner(file);//scans the file
			while (scanner.hasNextLine()){
				String line=scanner.nextLine();
				String[] comps=line.split(",");
				description.put(comps[0], comps[1]);
			}
			scanner.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//set up alpha dic
		filename = "alpha.csv";
		file = new File(filename);//creates new object file
		try {
			Scanner scanner = new Scanner(file);//scans the file
			while (scanner.hasNextLine()){
				String line=scanner.nextLine();
				String[] comps=line.split(",");
				alpha.put(comps[0], comps[1]);
			}
			scanner.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public String[] fields(String character){
		String alpha=this.alpha(character);
		String HTML=this.html(character);
		String decimal=this.decimal(character);
		String hex=this.hex(character);
		String java=this.java_code(character);
		String desc=this.description(character);
		
		String[] fields={alpha,HTML,decimal,hex,java,desc};
		return fields;
	}
	
	public int dec(String character){
		int dec = character.codePointAt(0);	
		
		return dec;
	}
	
	public String decimal(String character){
					//Turns the char into a decimal
		int dec = this.dec(character);
		String decimal = Integer.toString(dec);
		
		return decimal;
	}
	
	public String html(String character){
		String decimal = this.decimal(character);
		String html = "&#" + decimal;
		
		return html;
	}

	public String hex_num(String character){
		int decimal = this.dec(character);
		String hex = Integer.toHexString(decimal);
		
		//padding
		if (decimal < 16){
			hex = "000" + hex;
		} else if (decimal < 256){
			hex = "00" + hex;
		} else if (decimal < 4096){
			hex = "0" + hex;
		}
		return hex;
	}
	
	public String hex(String character){
		
		String hex=this.hex_num(character);
		
		//prefix
		String final_hex=new String();
		final_hex = "0x" + hex;
		
		return final_hex;
	}
	
	public String java_code(String character){
		int dec=this.dec(character);
		String hex=this.hex_num(character);
		String java_code=hex.toUpperCase();
		//Sets Java Code		
		if (dec < 65536){
			java_code="\\u"+java_code;
		} else{
			
			//Subtracts 0x10000(=65536) from the code point and converts to a binary string, then split it into an array of strings
			String binstr= Integer.toBinaryString(dec-65536);
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
			java_code="\\u"+highsurfu+"\\u"+lowsurfu;
		}
		
		return java_code;
	}
	
	public String description(String character){
		String hex=this.hex(character);
		String desc=new String();
		if (description.get(hex) != null){
			desc=description.get(hex);
		}else{
			desc="n/a";
		}
		return desc;
	}
	
	public String alpha(String character){
		String hex=this.hex(character);
		String alp=new String();
		if (alpha.get(hex) != null){
			alp=alpha.get(hex);
		}else{
			alp="n/a";
		}
		return alp;
	}
	
}

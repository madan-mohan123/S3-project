package Pages;

import java.io.File;

public class Rename {
	
	private static final String UNDERSCORE= "_";
	public void changeName(String f){
		File ol=new File(f);
		
		//original filename
		 String new1="";
		 String mynew="";
		
			for(int i=0;i<f.length();i++) {
				if(String.valueOf(f.charAt(i)).equals("\\")){
					new1= "";
					
					
				}
				else {
					new1 = new1 + String.valueOf(f.charAt(i));
					
				}
					
			}
			
			//ne file name
			String new2="";
			String asid="1";
			String suid="3";
			String pre="";
			
			//extract suffix of file
			
			for(int i=0;i<new1.length();i++) {
				if(String.valueOf(new1.charAt(i)).equals(".")){
					pre= "";
					
					
				}
				else {
					pre = pre + String.valueOf(new1.charAt(i));
				}
					
			}
			
			new2= asid + UNDERSCORE + suid + "." + pre;

			mynew= f.substring(0,(f.length()-new1.length()));
			mynew=mynew+new2;

			System.out.println(mynew);
			
			File ne=new File(mynew);
			
			if(ol.renameTo(ne)) {

			//code for upload for "mynew"
			System.out.println("hi");
		}
	
//		if(ne.renameTo(ol)) {
//
//			System.out.println("hi1");
//		}
		
}
	
	
	public static void main(String[] args) {
		
		
		Rename ob=new Rename();
		ob.changeName("D:\\colleage\\javascrpt\\web\\button.txt");



	}

}

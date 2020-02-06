
import java.util.*;

public class NumberEncodingUpdated {

	 static String codes[] = { "0","1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" }; 

        public static ArrayList<String> encoded(String s) 
		{
        	char[] ch1=s.toCharArray();
        	int j=0,k=0;
        	for (int i=0;i<s.length();i++) {
          		if(ch1[i]>=48 && ch1[i]<=57) {
       			    k++;
          		}
        	}
        	
        	char[] ch2=new char[k];
        	for (int i=0;i<s.length();i++) {
          		if(ch1[i]>=48 && ch1[i]<=57) {
       			    ch2[j++]=ch1[i];
          		}
        	}
        	
        	String str=new String(ch2);
        	
        	//System.out.println(str);
        	
        	for(int i=0;i<k-1;i++) {
        		if((ch2[i]=='1'&&ch2[i+1]=='0') || (ch2[i]=='0'&&ch2[i+1]=='1') || (ch2[i]=='1'&&ch2[i+1]=='1') || (ch2[i]=='0'&&ch2[i+1]=='0')) {
        			ArrayList<String> err=new ArrayList<String>();
        			err.add(str);		
        			return err;
        		}	
        	        
        	}
        	
			if (str.length() == 0) { 
				//System.out.println("4");
				ArrayList<String> eres = new ArrayList<String>(); 
				eres.add("");
				return eres; 
			} 
			
			//System.out.println("1");
			
			char ch = str.charAt(0); 

			String rest = str.substring(1); 
			
			//System.out.println("2");
			
			ArrayList<String> pres = encoded(rest); 
			
			//System.out.println("3");
			//System.out.println(pres);
			
			ArrayList<String> res = new ArrayList<String>(); 

			String code = codes[(int)ch - 48]; 
             
			//System.out.println(code);
			
			for (String val : pres) { 
				//System.out.println(val);               
				for (int i = 0; i < code.length(); i++) { 
					res.add(code.charAt(i) + val); 
					//System.out.println(res);
				} 
			} 
			return res; 
		} 

		public static void main(String[] args) 
		{ 
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter a phone number");
			String str=sc.nextLine();
			System.out.println(encoded(str)); 
			sc.close();
		} 
	} 



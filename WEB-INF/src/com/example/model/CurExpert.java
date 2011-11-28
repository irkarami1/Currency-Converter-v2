package com.example.model;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;


public class CurExpert{

    public double getRes(String from, String to, double amount){
	//double a=0.1;
	int ind1,ind2;
	double f,t=0;
	//String from="EUR";
	//String to="USD";
int zer=1;

	try {
while(amount>=1000000){
amount=amount/1000;
zer=zer*1000;
}


		String q1="http://www.google.com/ig/calculator?hl=en&q="+amount+from+"=?"+to;
               System.out.println(q1);
		URL convert = new URL(q1);
		BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream()));
		String answer = in.readLine();
		in.close();

		//from
		ind1=answer.indexOf('"');
		answer=answer.substring(ind1+1);
		System.out.println(answer+"\n");
		ind2=answer.indexOf('"');
		System.out.println("ind2"+ind2);
		from=answer.substring(0,ind2);

		//to
		answer=answer.substring(ind2+1);
		ind1=answer.indexOf('"');
		answer=answer.substring(ind1+1);
		System.out.println(answer+"\n");
		ind2=answer.indexOf('"');
		System.out.println("ind2"+ind2);
		to=answer.substring(0,ind2);

		//error
		answer=answer.substring(ind2+1);
		ind1=answer.indexOf('"');
		answer=answer.substring(ind1+1);
		System.out.println(answer+"\n");
		ind2=answer.indexOf('"');
		System.out.println("ind2"+ind2);
		String err=answer.substring(0,ind2);

		if(err.length()==0){
			//from value
			from=from.replaceAll("�","");
			ind1=from.indexOf(' ');
			from=from.substring(0,ind1);
		
			try{
				f = Double.parseDouble(from);
			      System.out.println("float f = " + f);
			}
			catch (NumberFormatException nfe){
			      System.out.println("NumberFormatException: " + nfe.getMessage());
			}
	  

			//to value
			to=to.replaceAll("�","");
			ind1=to.indexOf(' ');
			to=to.substring(0,ind1);
			try{
				t = Double.parseDouble(to);
			      System.out.println("float t = " + t);
			}
			catch (NumberFormatException nfe){
			      System.out.println("NumberFormatException: " + nfe.getMessage());
			}
		  }else{
			System.out.println("ErrorException: " + err);
		}
                //System.out.println(answer+" from "+from+" to "+to+" err " +err);


        } catch (MalformedURLException me) {
            	System.out.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            	System.out.println("IOException: " + ioe);
        }

return(t*zer);
	}
}

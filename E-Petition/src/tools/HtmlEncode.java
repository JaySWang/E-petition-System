package tools;

public class HtmlEncode {

	
	public static String htmlEncode(String s) {
		String newS="";
		
		for(int i=0;i<s.length();i++){
			newS=newS.concat(htmlEncode(s.charAt(i)));
		}
		return newS.toString();
	}



	private static String htmlEncode(char c) {
	    switch(c) {
	       case '&':
	           return"&amp;";
	       case '<':
	           return"&lt;";
	       case '>':
	           return"&gt;";
	       case '"':
	           return"&quot;";
	       case ' ':
	           return"&nbsp;";
	       default:
	           return c +"";
	    }
	}
}

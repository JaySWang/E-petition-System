package Test;


import static org.junit.Assert.*;

import org.junit.Test;

import tools.HtmlEncode;
public class TestHtmlEncode {

	
	
  //test ProposalService
@Test
   public void htmlEncode(){
	
	String s1="<& >";
	String s2="<script>alert(\"xss\")</script>";

	String[] sList={s1,s2};

	for(int i=0;i<sList.length;i++){
		sList[i]=HtmlEncode.htmlEncode(sList[i]);
	}
	String newS1="&lt;&amp;&nbsp;&gt;";
	String newS2="&lt;script&gt;alert(&quot;xss&quot;)&lt;/script&gt;";
			
   
	assertEquals(sList[0],newS1);
	assertEquals(sList[1],newS2);
			
			
			
   }




}

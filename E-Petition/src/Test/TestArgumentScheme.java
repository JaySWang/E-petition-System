package Test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.ArgumentScheme;
import model.AspectType;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IArgumentSchemeService;
import service.IAspectService;


public class TestArgumentScheme {

	
	@Test
	public void testSaveAndGet() throws Exception{
		
		   List<AspectType> ats = new ArrayList();
	
		AspectType atExpertise = new AspectType();
		atExpertise.setName("expertise");
		
		AspectType atAssertion = new AspectType();
		atAssertion.setName("assertion");
		
		AspectType atConlusion = new AspectType();
		atConlusion.setName("conclusion");
		
		ats.add(atExpertise);
		ats.add(atAssertion);
		ats.add(atConlusion);
		
	
		ArgumentScheme as = new ArgumentScheme();

		as.setAspectTypes(ats);
		String description = "some specialist knowlege is required that is not within our grasp.but maybe within someone else's";
		String name = "Expert Opinion";
	
		as.setDescription(description);
		as.setName(name);

try{		
BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");

		IArgumentSchemeService ass =  (IArgumentSchemeService) bf.getBean("argumentSchemeService");
		
		ass.save(as);
		int id = as.getId();
		ArgumentScheme as2 = ass.getArgumentSchemeById(id);
		
		assertEquals(as.getDescription(),as2.getDescription());
		assertEquals(as.getName(),as2.getName());
}	catch (Throwable t){
	t.printStackTrace();
}
		
		
		
	}
	
	
	
}

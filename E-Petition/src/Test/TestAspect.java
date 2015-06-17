package Test;

import static org.junit.Assert.*;

import model.Aspect;
import model.Proposal;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IAspectService;
import value.constValue;

public class TestAspect {

	@Test
	public void testSaveAndGet()  throws Exception{
		String value = "Should we invade Iraq?";
		String type = constValue.TOPIC;
		 int agree = 1;
		 int disagree = 2;
		int proposalId = 35;
		 
		 
		Aspect a = new Aspect();
		//a.setProposalId(proposalId);
		a.setValue(value);
		a.setType(type);
		a.setAgree(agree);
		a.setDisagree(disagree);
	

		
		BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
		
		IAspectService as =  (IAspectService) bf.getBean("aspectService");
	try{
		
		as.save(a);
		}
	catch(Throwable t){
		t.printStackTrace();
	}
	int id = a.getId();

	assertEquals((as.getAspectById(id)).getValue(),value);

		
		
	}

	
}

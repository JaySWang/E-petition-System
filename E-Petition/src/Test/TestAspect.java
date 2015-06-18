package Test;

import static org.junit.Assert.*;

import model.Aspect;
import model.CriticalQuestion;
import model.Proposal;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IAspectService;
import value.ConstValue;

public class TestAspect {

	@Test
	public void testSaveAndGet()  throws Exception{
		String value = "Should we invade Iraq?";
		String type = ConstValue.TOPIC;
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

	@Test
	public void testCriticalQuestion() throws Exception{
		int agree = 1;
		int disagree = 2;
		int na = 3;
		String value = "Do you think the action can achieve the goal?";
		
		
		CriticalQuestion cq1 = new CriticalQuestion();
		
		cq1.setAgree(agree);
		cq1.setDisagree(disagree);
		cq1.setNa(na);
		cq1.setValue(value);
		
		
		agree = 12;
		 disagree = 22;
	 na = 32;
	value = "Do you think the action is realistic?";
		
		
		CriticalQuestion cq2 = new CriticalQuestion();
		
		cq2.setAgree(agree);
		cq2.setDisagree(disagree);
		cq2.setNa(na);
		cq2.setValue(value);
		
		
		Aspect a = new Aspect();

BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
		
		IAspectService as =  (IAspectService) bf.getBean("aspectService");
		
		as.save(a);
		int id = a.getId();
        int size = as.getAspectById(id).getCriticalQuestions().size();
        a.addCriticalQuestion(cq1);
        a.addCriticalQuestion(cq2);
        as.update(a);
		assertEquals(as.getAspectById(id).getCriticalQuestions().size(),size+2);
		assertEquals(as.getAspectById(id).getCriticalQuestions().get(size).getValue(),cq1.getValue());

		assertEquals(as.getAspectById(id).getCriticalQuestions().get(size+1).getValue(),cq2.getValue());
	
	
	}
	
	
}

package Test;

import static org.junit.Assert.assertEquals;
import model.CriticalQuestion;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IAspectService;
import service.ICriticalQuestionService;

public class TestCriticalQuestion {

	
	@Test
	public void testValue() throws Exception{
		int agree = 1;
		int disagree = 2;
		int na = 3;
		String value = "Do you think the action can achieve the goal?";
		
		
		CriticalQuestion cq = new CriticalQuestion();
		
		cq.setAgree(agree);
		cq.setDisagree(disagree);
		cq.setNa(na);
		cq.setValue(value);
		
		
		
		
		
	BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
		
		ICriticalQuestionService cqs =  (ICriticalQuestionService) bf.getBean("criticalQuestionService");
	try{
		
		cqs.save(cq);
		}
	catch(Throwable t){
		t.printStackTrace();
	}
	int id = cq.getId();

	assertEquals((cqs.getCriticalQuestionById(id)).getValue(),value);
		
	}
	
	
	
}

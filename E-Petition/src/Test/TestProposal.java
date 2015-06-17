package Test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IProposalService;

import dao.ProposalDAO;

import model.Aspect;
import model.Proposal;
import static org.junit.Assert.*;
public class TestProposal {

	
	
	
	//SAGV argument schema

	
	@Test
	public void values() throws Exception{
		String topic = "Should we invade Iraq?";
		String situation = "Saddam is running an oppressive regime, Saddam has WMD";
		String action = "send troop to invade Irap";
		String goal = "Restore democracy to Iraq, Remove the WMD";
		String value = "Remove the WMD promotes World security, Restore democracy to Iraq promotes Human rights";
		
		Proposal p = new Proposal();

		Aspect aTopic = new Aspect();
		aTopic.setType("topic");
		aTopic.setValue(topic);
		
		Aspect aSituation = new Aspect();
		aSituation.setType("situation");
		aSituation.setValue(situation);
		
		Aspect aAction = new Aspect();
		aAction.setType("action");
		aAction.setValue(action);
		
		Aspect aGoal = new Aspect();
		aGoal.setType("goal");
		aGoal.setValue(goal);
		
		Aspect aValue = new Aspect();
		aValue.setType("value");
		aValue.setValue(value);
		
		
		
		p.setTopic(aTopic);
		p.setSituation(aSituation);
		
		p.setAction(aAction);
		p.setGoal(aGoal);
		p.setValue(aValue);
	    
		
		
		
		assertEquals(p.getTopic(),aTopic);
		assertEquals(p.getSituation(),aSituation);
		assertEquals(p.getAction(),aAction);
		assertEquals(p.getGoal(),aGoal);
		assertEquals(p.getValue(),aValue);
		

	}
	
	
	
	@Test
	public void save() throws Exception{
		String topic = "Should we invade Iraq?";
		String situation = "Saddam is running an oppressive regime, Saddam has WMD";
		String action = "send troop to invade Irap";
		String goal = "Restore democracy to Iraq, Remove the WMD";
		String value = "Remove the WMD promotes World security, Restore democracy to Iraq promotes Human rights";
		
		Proposal p = new Proposal();

		

		Aspect aTopic = new Aspect();
		aTopic.setType("topic");
		aTopic.setValue(topic);
		
		Aspect aSituation = new Aspect();
		aSituation.setType("situation");
		aSituation.setValue(situation);
		
		Aspect aAction = new Aspect();
		aAction.setType("action");
		aAction.setValue(action);
		
		Aspect aGoal = new Aspect();
		aGoal.setType("goal");
		aGoal.setValue(goal);
		
		Aspect aValue = new Aspect();
		aValue.setType("value");
		aValue.setValue(value);
		
		
		
		p.setTopic(aTopic);
		p.setSituation(aSituation);
		
		p.setAction(aAction);
		p.setGoal(aGoal);
		p.setValue(aValue);
	    
	
		BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
		ProposalDAO pdao = (ProposalDAO) bf.getBean("proposalDAO");
		
		int preCount = pdao.getProposals().size();
		pdao.create(p);
		
		assertTrue(preCount+1==pdao.getProposals().size());
	
		}
	
   @Test
   public void getProposalById() throws Exception{
	   String topic = "Iraq?";
		String situation = "Saddam is running an oppressive regime, Saddam has WMD";
		String action = "send troop to invade Irap";
		String goal = "Restore democracy to Iraq, Remove the WMD";
		String value = "Remove the WMD promotes World security, Restore democracy to Iraq promotes Human rights";
		
		Proposal p = new Proposal();

		Aspect aTopic = new Aspect();
		aTopic.setType("topic");
		aTopic.setValue(topic);
		
		Aspect aSituation = new Aspect();
		aSituation.setType("situation");
		aSituation.setValue(situation);
		
		Aspect aAction = new Aspect();
		aAction.setType("action");
		aAction.setValue(action);
		
		Aspect aGoal = new Aspect();
		aGoal.setType("goal");
		aGoal.setValue(goal);
		
		Aspect aValue = new Aspect();
		aValue.setType("value");
		aValue.setValue(value);
		
		
		
		p.setTopic(aTopic);
		p.setSituation(aSituation);
		
		p.setAction(aAction);
		p.setGoal(aGoal);
		p.setValue(aValue);
	    
		
		BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
ProposalDAO pdao = (ProposalDAO) bf.getBean("proposalDAO");
		
		pdao.create(p);
		
		int id = p.getId();
		
		assertEquals((pdao.find(id)).getTopic().getValue(),aTopic.getValue());
	   
   }
   
  //test ProposalService
@Test
   public void proposalService(){
	   
	  String topic = "I";
			String situation = "Saddam is running an oppressive regime, Saddam has WMD";
			String action = "send troop to invade Irap";
			String goal = "Restore democracy to Iraq, Remove the WMD";
			String value = "Remove the WMD promotes World security, Restore democracy to Iraq promotes Human rights";
			
			Proposal p = new Proposal();

			Aspect aTopic = new Aspect();
			aTopic.setType("topic");
			aTopic.setValue(topic);
			
			Aspect aSituation = new Aspect();
			aSituation.setType("situation");
			aSituation.setValue(situation);
			
			Aspect aAction = new Aspect();
			aAction.setType("action");
			aAction.setValue(action);
			
			Aspect aGoal = new Aspect();
			aGoal.setType("goal");
			aGoal.setValue(goal);
			
			Aspect aValue = new Aspect();
			aValue.setType("value");
			aValue.setValue(value);
			
			
			
			p.setTopic(aTopic);
			p.setSituation(aSituation);
			
			p.setAction(aAction);
			p.setGoal(aGoal);
			p.setValue(aValue);

			BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
		
				IProposalService ps =  (IProposalService) bf.getBean("proposalService");
			try{
				
				ps.save(p);
				}
			catch(Throwable t){
				t.printStackTrace();
			}
			
			int id = p.getId();

			assertEquals((ps.getProposalById(id)).getTopic().getValue(),aTopic.getValue());

		
			assertTrue(ps.getProposals().size()>0);
			
			
			
   }


}

package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IProposalService;

import dao.ProposalDAO;

import model.ArgumentScheme;
import model.Aspect;
import model.AspectType;
import model.Proposal;
import static org.junit.Assert.*;
public class TestProposal {

	
	
	
	//SAGV argument schema

	String topic = "Should we invade Iraq?";
	String situation = "Saddam is running an oppressive regime, Saddam has WMD";
	String action = "send troop to invade Irap";
	String goal = "Restore democracy to Iraq, Remove the WMD";
	String value = "Remove the WMD promotes World security, Restore democracy to Iraq promotes Human rights";
	
	
	
	
	private Map<String,Aspect> getAspects(){
		
	    Map<String,Aspect> aspects=new HashMap();
	       
	       
	       
      	
          for(AspectType s : getScheme().getAspectTypes()){
        	 
       	   if(s.getName().equalsIgnoreCase("topic")){
       		 Aspect a = new Aspect();
       	  a.setType(s.getName());
       		   a.setValue(topic);
       	  	   aspects.put(s.getName(), a);
       	   }else if (s.getName().equalsIgnoreCase("situation")){
       		 Aspect a = new Aspect();
       	  a.setType(s.getName());
       		   a.setValue(situation);
       	  	   aspects.put(s.getName(), a);
       	   }else if (s.getName().equalsIgnoreCase("action")){
       		 Aspect a = new Aspect();
       	  a.setType(s.getName());
       		   a.setValue(action);
       	  	   aspects.put(s.getName(), a);
       	   }else if (s.getName().equalsIgnoreCase("goal")){
       		 Aspect a = new Aspect();
       	  a.setType(s.getName());
       		   a.setValue(goal);
       	  	   aspects.put(s.getName(), a);
       	   }else if (s.getName().equalsIgnoreCase("value")){
       		 Aspect a = new Aspect();
       	  a.setType(s.getName());
       		   a.setValue(value);
       	  	   aspects.put(s.getName(), a);
       	   }
       	   
       	   
     
       	   
          }
          return aspects;
		
	}

	private ArgumentScheme getScheme(){
		
		
	
		
		AspectType atTopic = new AspectType();
		atTopic.setName("topic");
		
		AspectType atSituation = new AspectType();
		atSituation.setName("situation");
		
		AspectType atAction = new AspectType();
		atAction.setName("action");
		
		AspectType atGoal = new AspectType();
		atGoal.setName("goal");

		
		AspectType atValue = new AspectType();
		atValue.setName("value");
		
		ArgumentScheme as = new ArgumentScheme();
		List<AspectType> ats = new ArrayList();
		ats.add(atTopic);
		ats.add(atSituation);
		ats.add(atAction);
		ats.add(atGoal);
		ats.add(atValue);
		
		as.setAspectTypes(ats);
		
		
		
		return as;
		
		
	}
	
	
	
	private Proposal getProposal(){
		
	
		
		Proposal p = new Proposal();

		   p.setArgumentScheme(getScheme());
		
	
		
	 

	          p.setAspects(getAspects());
		
		
		
		return p;
	}
	
	@Test
	public void values() throws Exception{
	

		
		
	
		       Map<String,Aspect> aspects2=getProposal().getAspects();

		
		
		assertEquals(aspects2.get("topic").getValue(),getAspects().get("topic").getValue());
		assertEquals(aspects2.get("situation").getValue(),getAspects().get("situation").getValue());
		assertEquals(aspects2.get("action").getValue(),getAspects().get("action").getValue());
		assertEquals(aspects2.get("goal").getValue(),getAspects().get("goal").getValue());
		assertEquals(aspects2.get("value").getValue(),getAspects().get("value").getValue());
		

	}
	
	
	
	@Test
	public void save() throws Exception{
		
		
		
		
		
		Proposal p = getProposal();
	
		BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
		ProposalDAO pdao = (ProposalDAO) bf.getBean("proposalDAO");
		
		int preCount = pdao.getProposals().size();
		pdao.create(p);
		
		assertTrue(preCount+1==pdao.getProposals().size());
		
		}

   
  //test ProposalService
@Test
   public void proposalService(){
	   
	 topic = "I";
			situation = "Saddam is running an oppressive regime, Saddam has WMD";
			action = "send troop to invade Irap";
		goal = "Restore democracy to Iraq, Remove the WMD";
		value = "Remove the WMD promotes World security, Restore democracy to Iraq promotes Human rights";
			
			Proposal p = getProposal();

	

			BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
		
				IProposalService ps =  (IProposalService) bf.getBean("proposalService");
			try{
				
				ps.save(p);
				}
			catch(Throwable t){
				t.printStackTrace();
			}
			
			int id = p.getId();

			assertEquals((ps.getProposalById(id)).getAspects().get("topic").getValue(),topic);

		
			assertTrue(ps.getProposals().size()>0);
			
			
			
   }




}

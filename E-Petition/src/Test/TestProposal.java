package Test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.DAOImpl;
import dao.ProposalDAO;

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

		

		p.setTopic(topic);
		p.setSituation(situation);
		p.setAction(action);
		p.setGoal(goal);
		p.setValue(value);
	    
		assertEquals(p.getTopic(),topic);
		assertEquals(p.getSituation(),situation);
		assertEquals(p.getAction(),action);
		assertEquals(p.getGoal(),goal);
		assertEquals(p.getValue(),value);
		

	}
	
	
	
	@Test
	public void save() throws Exception{
		
		String topic = "Should we invade Iraq?";
		String situation = "Saddam is running an oppressive regime, Saddam has WMD";
		String action = "send troop to invade Irap";
		String goal = "Restore democracy to Iraq, Remove the WMD";
		String value = "Remove the WMD promotes World security, Restore democracy to Iraq promotes Human rights";
		
		Proposal p = new Proposal();

		p.setTopic(topic);
		p.setSituation(situation);
		p.setAction(action);
		p.setGoal(goal);
		p.setValue(value);
	    
		BeanFactory bf = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
		DAOImpl dao = (DAOImpl) bf.getBean("dao");
		ProposalDAO pdao = new ProposalDAO();
		pdao.setDAO(dao);
		
		
		pdao.create(p);
		
		assertTrue(pdao.getProposals().size()>0);
	}
	



}

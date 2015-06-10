package Test;

import org.junit.Test;

import model.Proposal;
import static org.junit.Assert.*;
public class TestProposal {

	
	//SAGV argument schema
	
	@Test
	public void Values() throws Exception{
		
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
	
	



}

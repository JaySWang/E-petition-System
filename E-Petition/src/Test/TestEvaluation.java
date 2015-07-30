package Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import value.ConstValue;


import evaluation.Evaluation;
import evaluation.IEvaluation;

import model.Aspect;
import model.CriticalQuestion;
import model.Proposal;
import static org.junit.Assert.*;
public class TestEvaluation {

	
	
	
	//SAGV argument schema

	String topic = "Should we invade Iraq?";
	String situation = "Saddam is running an oppressive regime, Saddam has WMD";
	String action = "send troop to invade Irap";
	String goal = "Restore democracy to Iraq, Remove the WMD";
	String value = "Remove the WMD promotes World security, Restore democracy to Iraq promotes Human rights";
	
	
	


	
	//evaluation just base on the general votes
	
	@Test
	public void BasicEvaluation() throws Exception{
	
	  int agree;
	  int disagree;	
	  IEvaluation e =new Evaluation(); 
      Proposal p = new Proposal();
     
      
      // notAccept
      agree=10;
      disagree=20;
      
      p.setAgree(agree);
      p.setDisagree(disagree);
      
      e.setTarget(p);
      assertTrue(ConstValue.NotAccpeted.equalsIgnoreCase(e.basicEvaluation()));
      
      
      agree=0;
      disagree=0;
      
      p.setAgree(agree);
      p.setDisagree(disagree);
      
      e.setTarget(p);
      assertTrue(ConstValue.NotAccpeted.equalsIgnoreCase(e.basicEvaluation()));
      
      
      //accept
      agree=21;
      disagree=20;
      
      p.setAgree(agree);
      p.setDisagree(disagree);
      
      e.setTarget(p);
      assertTrue(ConstValue.Accpeted.equalsIgnoreCase(e.basicEvaluation()));
    
      

		
		

	}
	
	
	
	@Test
	public void CQEvaluation() throws Exception{
		  IEvaluation e =new Evaluation(); 

		
		// failed proposal
		Proposal p = new Proposal();
		Aspect situation = new Aspect();
		
		//failed cq
		CriticalQuestion cqs1 = new CriticalQuestion();
		cqs1.setAgree(10);
		cqs1.setDisagree(20);
		CriticalQuestion cqs2 = new CriticalQuestion();
		cqs2.setAgree(30);
		cqs2.setDisagree(20);
		//failed aspect
		situation.addCriticalQuestion(cqs1);
		situation.addCriticalQuestion(cqs2);

		//win cq
		Aspect action = new Aspect();
		CriticalQuestion cqa1 = new CriticalQuestion();
		cqa1.setAgree(30);
		cqa1.setDisagree(20);
		CriticalQuestion cqa2 = new CriticalQuestion();
		cqa2.setAgree(30);
		cqa2.setDisagree(20);
		//won aspect
		situation.addCriticalQuestion(cqa1);
		situation.addCriticalQuestion(cqa2);

		//not accept
		
		List<Aspect> aspects = new ArrayList();		
		aspects.add(situation);
		aspects.add(action);
		p.setAspects(aspects);
		e.setTarget(p);
		assertTrue(ConstValue.NotAccpeted.equalsIgnoreCase(e.CQEvaluation()));
		
		
		
		
		// won proposal
		p = new Proposal();
	    situation = new Aspect();
		
	    //won cq
	    cqs1 = new CriticalQuestion();
		cqs1.setAgree(19);
		cqs1.setDisagree(20);
        cqs2 = new CriticalQuestion();
		cqs2.setAgree(10);
		cqs2.setDisagree(20);
		
		//won aspect
		situation.addCriticalQuestion(cqs1);
		situation.addCriticalQuestion(cqs2);

		//won cq
		action = new Aspect();
		cqa1 = new CriticalQuestion();
		cqa1.setAgree(10);
		cqa1.setDisagree(20);
		cqa2 = new CriticalQuestion();
		cqa2.setAgree(10);
		cqa2.setDisagree(20);
		
		//won aspect
				action.addCriticalQuestion(cqa1);
				action.addCriticalQuestion(cqa2);
		
				
		aspects = new ArrayList();		
		aspects.add(situation);
		aspects.add(action);
		p.setAspects(aspects);
		
		
		// accept
		e.setTarget(p);
	    assertTrue(ConstValue.Accpeted.equalsIgnoreCase(e.CQEvaluation())); 
		
		
		}

  
	@Test
   public void ASEvaluation(){
	
			
		
		
		 IEvaluation e =new Evaluation(); 


		 
		 //accepted
		 
			Proposal p = new Proposal();
			Aspect situation = new Aspect();
			
			//failed cq
			CriticalQuestion cqs1 = new CriticalQuestion();
			cqs1.setAgree(21);
			cqs1.setDisagree(20);
			
			Proposal attacker = getAcceptedProposal();
			cqs1.addAttacker(attacker);
			
			
			
			
			//failed cq
			CriticalQuestion cqs2 = new CriticalQuestion();
			cqs2.setAgree(10);
			cqs2.setDisagree(20);
			
			//won aspect
			situation.addCriticalQuestion(cqs1);
			situation.addCriticalQuestion(cqs2);

			//failed cq
			Aspect action = new Aspect();
			CriticalQuestion cqa1 = new CriticalQuestion();
			cqa1.setAgree(22);
			cqa1.setDisagree(20);
			
			
			Proposal attacker2 = getAcceptedProposal();
			cqa1.addAttacker(attacker2);
			Proposal attacker3 = getAcceptedProposal();
			cqa1.addAttacker(attacker3);
			
			//failed cq
			CriticalQuestion cqa2 = new CriticalQuestion();
			cqa2.setAgree(19);
			cqa2.setDisagree(20);
			
			
			//won aspect
			situation.addCriticalQuestion(cqa1);
			situation.addCriticalQuestion(cqa2);

			// accepted
			
			List<Aspect> aspects = new ArrayList();		
			aspects.add(situation);
			aspects.add(action);
			p.setAspects(aspects);
			e.setTarget(p);
			assertTrue(ConstValue.Accpeted.equalsIgnoreCase(e.ASEvaluation(p)));
			
			
			
			
			
			
		// not accept	
			
			p = new Proposal();
		    situation = new Aspect();
			
		    //failed cq
		    cqs1 = new CriticalQuestion();
			cqs1.setAgree(19);
			cqs1.setDisagree(20);
			
			
			//failed cq
	        cqs2 = new CriticalQuestion();
			cqs2.setAgree(18);
			cqs2.setDisagree(20);
			Proposal supporter = getAcceptedProposal();
			cqs2.addSupporter(supporter);
			
			
			//won aspect
			situation.addCriticalQuestion(cqs1);
			situation.addCriticalQuestion(cqs2);

			//failed cq
			action = new Aspect();
			cqa1 = new CriticalQuestion();
			cqa1.setAgree(10);
			cqa1.setDisagree(20);
			
			//won cq
			cqa2 = new CriticalQuestion();
			cqa2.setAgree(20);
			cqa2.setDisagree(20);
			Proposal supporter2 = getAcceptedProposal();
			cqa2.addSupporter(supporter2);
			
			//failed aspect
					action.addCriticalQuestion(cqa1);
					action.addCriticalQuestion(cqa2);
			
					
			aspects = new ArrayList();		
			aspects.add(situation);
			aspects.add(action);
			p.setAspects(aspects);
			
			
			// accept
			e.setTarget(p);
		    assertTrue(ConstValue.NotAccpeted.equalsIgnoreCase(e.ASEvaluation(p)));
		
		
		
		
			
   }



	private Proposal getAcceptedProposal() {
		// won proposal
					Proposal p = new Proposal();
					Aspect situation = new Aspect();
					
					//failed cq
					CriticalQuestion cqs1 = new CriticalQuestion();
					cqs1.setAgree(21);
					cqs1.setDisagree(22);
					

					//failed cq
					CriticalQuestion cqs2 = new CriticalQuestion();
					cqs2.setAgree(10);
					cqs2.setDisagree(20);
					
					//won aspect
					situation.addCriticalQuestion(cqs1);
					situation.addCriticalQuestion(cqs2);

					//failed cq
					Aspect action = new Aspect();
					CriticalQuestion cqa1 = new CriticalQuestion();
					cqa1.setAgree(15);
					cqa1.setDisagree(20);
					CriticalQuestion cqa2 = new CriticalQuestion();
					cqa2.setAgree(10);
					cqa2.setDisagree(20);
					
					//won aspect
					situation.addCriticalQuestion(cqa1);
					situation.addCriticalQuestion(cqa2);

					
					//not accepted proposal
					List<Aspect> aspects = new ArrayList();		
					aspects.add(situation);
					aspects.add(action);
					p.setAspects(aspects);
					
					
					return p;
	}




}

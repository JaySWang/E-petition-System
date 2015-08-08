package evaluation;

import value.ConstValue;
import model.CriticalQuestion;
import model.Proposal;
import model.Aspect;

public class Evaluation implements IEvaluation {

	
	
	Proposal target;
	
	//weight for success attackers or supporters to add votes to corresponding critical question 
	int weight = 2;
	
	public Evaluation(Proposal p) {
		target=p;
		
	}

	public Evaluation() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	@Override
	public String basicEvaluation() {

		String result;
		
		if(target.getAgree()>target.getDisagree()){
			result=ConstValue.Accpeted;
		}else{
			result=ConstValue.NotAccpeted;
		}
		
		
		
		return result;
	}

	@Override
	public void setTarget(Proposal p) {
		target = p;		
	}

	@Override
	public String CQEvaluation() {
	
		//any cq in any aspect win,the proposal is not accepted ,Otherwise accepted
		//When evaluation assume that those who votes agree on the proposal,disagree with all the critical questions
		for(Aspect a: target.getAspects()){
			for(CriticalQuestion cq:a.getCriticalQuestions()){
				if(cq.getAgree()>=cq.getDisagree()+target.getAgree()){
					return ConstValue.NotAccpeted;
				}
					
				
				
			}
			
			
		}
		
		
		return ConstValue.Accpeted;
	}

	@Override
	public String ASEvaluation(Proposal p) {

		//any cq in any aspect win,the proposal is not accepted ,Otherwise accepted
		//when evaluating cq,also consider its attackers and supporters.for each won one,add votes to the cq
		//totoal adding votes = number of won ones*weight
		
		
				for(Aspect a: p.getAspects()){
					for(CriticalQuestion cq:a.getCriticalQuestions()){
						int disagreeIncreation=0;
						int aggreeIncreation=0;
						
						for(Proposal attacker:cq.getAttackers()){
							
							if(this.ASEvaluation(attacker)==ConstValue.Accpeted){
								disagreeIncreation+=weight;
							}
						}
						for(Proposal supporter:cq.getSupporters()){
							if(this.ASEvaluation(supporter)==ConstValue.Accpeted){
								aggreeIncreation+=weight;
								}		
						}
					if((cq.getAgree()+aggreeIncreation)>=(cq.getDisagree()+disagreeIncreation+p.getAgree())){
							return ConstValue.NotAccpeted;

						}			
					}
				}
		

	
	
				return ConstValue.Accpeted;

	
	}
	
}

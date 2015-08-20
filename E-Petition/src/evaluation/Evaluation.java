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
	public void setTarget(Proposal p) {
		target = p;		
	}

	
	@Override
	public String basicEvaluation() {
		//just consider the 
		String result;	
		if(target.getAgree()>target.getDisagree()){
			result=ConstValue.Accpeted;
		}else{
			result=ConstValue.NotAccpeted;
		}
		
		return result;
	}

	@Override
	public String ordinaryEvaluation() {
		//1 if any critical question of any aspect win,the proposal is not accepted
		//  Otherwise  it is accepted
		//2 When evaluating, assuming that those who votes agree on the proposal,
		//  disagree with all the critical questions
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
	public String advancedEvaluation(Proposal p) {
		//1 if any critical question of any aspect win,the proposal is not accepted,
		//  Otherwise it is accepted.
		//2 when evaluating a critical question,also consider its attackers and supporters.
		//  for each won one,add votes or negative votes to the critical question
		//3 total votes to add = number of won ones*weight
		//4 default weight is 2		
				for(Aspect a: p.getAspects()){
					for(CriticalQuestion cq:a.getCriticalQuestions()){
						int voteIncreation=0;
						int negativeVotesIncreation=0;
						
						for(Proposal attacker:cq.getAttackers()){
							//recursively evaluate attacker 
							if(this.advancedEvaluation(attacker)==ConstValue.Accpeted){
								negativeVotesIncreation+=weight;
							}
						}
						for(Proposal supporter:cq.getSupporters()){
							//recursively evaluate supporter 
							if(this.advancedEvaluation(supporter)==ConstValue.Accpeted){
								voteIncreation+=weight;
								}		
						}
					if((cq.getAgree()+voteIncreation)>=(cq.getDisagree()+negativeVotesIncreation+p.getAgree())){
							return ConstValue.NotAccpeted;
						}			
					}
				}
					return ConstValue.Accpeted;
	}
	
}

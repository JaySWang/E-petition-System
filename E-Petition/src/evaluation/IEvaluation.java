package evaluation;

import model.Proposal;

public interface IEvaluation {

	String basicEvaluation();

	void setTarget(Proposal p);

	String ordinaryEvaluation();

	String advancedEvaluation(Proposal p);

}

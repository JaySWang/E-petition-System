package evaluation;

import model.Proposal;

public interface IEvaluation {

	String basicEvaluation();

	void setTarget(Proposal p);

	String CQEvaluation();

	String ASEvaluation(Proposal p);

}

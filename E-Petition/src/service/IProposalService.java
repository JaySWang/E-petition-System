package service;

import java.util.List;

import model.Proposal;


public interface IProposalService {


	public List<Proposal> getProposals();
	
	public Proposal getProposalById(int id);
	
	public void save(Proposal baseBean); 
	
	public void delete(Proposal baseBean);

	public void voteAgree(Proposal p, boolean agree);

	public void update(Proposal p);

	public List<Proposal> getGeneralProposals();

}

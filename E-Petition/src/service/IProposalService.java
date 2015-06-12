package service;

import java.util.List;

import model.Proposal;


public interface IProposalService extends IService{


	public List<Proposal> getProposals();
	
	public Proposal find(int id);

}

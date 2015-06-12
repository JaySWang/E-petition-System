package dao;

import java.util.ArrayList;
import java.util.List;

import model.Proposal;

public class ProposalDAO {

	IDAO dao;
	
	public List<Proposal> getProposals(){
	   List<Proposal> l = new ArrayList();
		 String hql=" select p from Proposal p";

		l = dao.list(hql);
	   
		return l;
	}

	public void setDAO(IDAO idao) {
		this.dao = idao;
	}

	public void create(Proposal p) {
		try{
          dao.create(p);		
	}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}

	public Proposal getProposalById(int id) {
		
		Proposal p = (Proposal) dao.find(Proposal.class, id);
		return p;
	}
}
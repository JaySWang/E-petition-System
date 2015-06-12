package service;


import java.util.ArrayList;
import java.util.List;

import dao.ProposalDAO;


import model.BaseEntityBean;
import model.Proposal;


public class ProposalServiceImpl  extends ServiceImpl implements IProposalService {

	public void create(Proposal baseBean) {
		this.getDao().create(baseBean);
		
	}

	public void save(Proposal baseBean) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Proposal baseBean) {
		// TODO Auto-generated method stub
		
	}

	public List<Proposal> getProposals() {

		ProposalDAO pdao = new ProposalDAO();
		pdao.setDAO(this.getDao());
		 
			List proposals = new ArrayList();
			proposals =	pdao.getProposals();

		return proposals;
	}

	@Override
	public void create(BaseEntityBean baseBean) {
		(this.getDao()).create(baseBean);		
	}

	
	public Proposal find(int id) {
		
		return (Proposal) this.getDao().find(Proposal.class, id);
	}




	
}

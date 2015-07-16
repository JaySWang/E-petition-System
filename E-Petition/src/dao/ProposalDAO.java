package dao;

import java.util.ArrayList;
import java.util.List;


import model.Proposal;

public class ProposalDAO{

	IDAO dao;
	
	
	
	
	
	public IDAO getDao() {
		return dao;
	}

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

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



	public Proposal find(int id) {
		String hql="select p from Proposal p where p.id=(:id)";

		List<Proposal> proposals=this.getDao().createQuery(hql).setParameter("id", id).list();
		
		if(proposals.size()>0)
			return proposals.get(0);
		
		return null;

	}

	public void update(Proposal p) {
     dao.updata(p);		
	}

	public List getProposalsByType(String type) {
		String hql="select p from Proposal p where p.type=(:type)";

		List<Proposal> proposals=this.getDao().createQuery(hql).setParameter("type", type).list();

		return proposals;
	}
}

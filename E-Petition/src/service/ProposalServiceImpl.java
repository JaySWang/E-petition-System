package service;


import java.util.List;


import model.BaseEntityBean;
import model.Proposal;


public class ProposalServiceImpl  extends ServiceImpl implements IProposalService {

	public void create(Object baseBean) {
		this.getDao().create(baseBean);
		
	}

	public void save(BaseEntityBean baseBean) {
		// TODO Auto-generated method stub
		
	}

	public void delete(BaseEntityBean baseBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getProposals() {
		 String hql=" select p from Proposal p";
			List<Proposal> proposals=(List<Proposal>) (this.getDao()).createQuery(hql).list();
			
		return proposals;
	}

	@Override
	public void create(BaseEntityBean baseBean) {
		// TODO Auto-generated method stub
		
	}

	


	
}

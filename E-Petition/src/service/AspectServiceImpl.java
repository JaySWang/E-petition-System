package service;

import dao.AspectDAO;
import model.Aspect;

public class AspectServiceImpl implements IAspectService {

	
	AspectDAO adao;
	
	
	
	
	
	public AspectDAO getAdao() {
		return adao;
	}

	public void setAdao(AspectDAO adao) {
		this.adao = adao;
	}

	@Override
	public void save(Aspect a) {
		adao.create(a);
	}

	@Override
	public Aspect getAspectById(int id) {
		
			return adao.find(id);
	}



}

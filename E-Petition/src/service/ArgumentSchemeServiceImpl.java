package service;

import java.util.ArrayList;
import java.util.List;

import dao.ArgumentSchemeDAO;

import model.ArgumentScheme;

public class ArgumentSchemeServiceImpl implements IArgumentSchemeService {

	ArgumentSchemeDAO asdao;
	
	
	
	public ArgumentSchemeDAO getAsdao() {
		return asdao;
	}

	public void setAsdao(ArgumentSchemeDAO asdao) {
		this.asdao = asdao;
	}

	@Override
	public List<ArgumentScheme> getArgumentSchemes() {
		return asdao.geArgumentSchemes();
	}

	@Override
	public ArgumentScheme getArgumentSchemeById(int id) {
		// TODO Auto-generated method stub
		return asdao.find(id);
	}

	@Override
	public void save(ArgumentScheme as) {
		asdao.create(as);
	}

	@Override
	public void delete(ArgumentScheme as) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ArgumentScheme as) {
		asdao.update(as);
	}

	@Override
	public ArgumentScheme getArgumentSchemeByName(String sName) {
		

		
		return asdao.findByName(sName);
	}

	@Override
	public List<ArgumentScheme> getNotGeneralProposalSchemes(){
		List<ArgumentScheme> asListTemp = asdao.geArgumentSchemes();
		List<ArgumentScheme> asList = new ArrayList();
		for(ArgumentScheme as:asListTemp){
        	if(!(as.getName().equalsIgnoreCase("General Proposal"))){
        		asList.add(as);
		}
	}
		return asList;

}
	@Override
	public List<ArgumentScheme> getGeneralProposalSchemes(){
		List<ArgumentScheme> asListTemp = asdao.geArgumentSchemes();
		List<ArgumentScheme> asList = new ArrayList();
		for(ArgumentScheme as:asListTemp){
        	if((as.getName().equalsIgnoreCase("General Proposal"))){
        		asList.add(as);
		}
	}
		return asList;

}
}
package service;

import java.util.List;

import model.ArgumentScheme;


public interface IArgumentSchemeService {


	public List<ArgumentScheme> getArgumentSchemes();
	
	public ArgumentScheme getArgumentSchemeById(int id);
	
	public void save(ArgumentScheme baseBean); 
	
	public void delete(ArgumentScheme baseBean);


	public void update(ArgumentScheme p);

}

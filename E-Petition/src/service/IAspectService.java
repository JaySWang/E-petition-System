package service;

import model.Aspect;

public interface IAspectService {

	public void save(Aspect a);

	public Aspect getAspectById(int id);

	public void update(Aspect a);

}

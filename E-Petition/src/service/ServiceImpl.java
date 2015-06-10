package service;

import java.util.List;

import dao.IDAO;

import model.BaseEntityBean;





public abstract class ServiceImpl<T extends BaseEntityBean> implements IService<T> {

	protected IDAO<T> dao;

	public IDAO<T> getDao() {
		return dao;
	}

	public void setDao(IDAO<T> dao) {
		this.dao = dao;
	}

	public T find(Class<T> clazz, int id) {
		return dao.find(clazz, id);
	}

	public abstract void create(T baseBean);

	public void delete(T baseBean) {
		
		dao.delete(baseBean);
	}

	public int getTotalCount(String hql, Object... params) {
		return dao.getTotalCount(hql, params);
	}

	public void save(T baseBean) {
		dao.save(baseBean);
	}

	public List<T> list(String hql) {
		return dao.list(hql);
	}

	public List<T> list(String hql, int firstResult, int maxSize,
			Object... params) {
		return dao.list(hql, firstResult, maxSize, params);
	}

}

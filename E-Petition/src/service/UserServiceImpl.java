package service;

import model.User;
import dao.UserDAO;

public class UserServiceImpl implements IUserService {

	
	UserDAO udao;

	public UserDAO getUdao() {
		return udao;
	}

	public void setUdao(UserDAO udao) {
		this.udao = udao;
	}

	@Override
	public User getUserByName(String userName) {
		return udao.getUserByUserName(userName);
	}
	
	
	
	
	



}

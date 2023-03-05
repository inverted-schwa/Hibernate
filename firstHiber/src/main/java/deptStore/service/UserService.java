package deptStore.service;

import deptStore.dao.UserDao;

public class UserService {
	public UserDao udao;
	
	public void login(String username, String password) {
		udao.checkLogin(username, password);
	}
}

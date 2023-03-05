package deptStore.service;

import java.util.Scanner;

import deptStore.dao.UserDao;

public class UserService {
	public UserDao udao;
	private Scanner sc;
	
	public void login(String username, String password) {
		udao.checkLogin(username, password);
	}
	
	public void signup() {
		sc = new Scanner(System.in);
		System.out.println("Please enter your name");
		String name = sc.nextLine();
		System.out.println("Please enter your id");
		int id = sc.nextInt();
		System.out.println("Please enter your username");
		String username = sc.nextLine();
		System.out.println("Please enter your password");
		String pass = sc.nextLine();
		System.out.println("Please enter your email");
		String email = sc.nextLine();
		udao.insert(id, username, email, pass, id, false, null);
	}
}

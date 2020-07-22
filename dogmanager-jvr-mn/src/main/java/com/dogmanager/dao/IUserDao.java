package com.dogmanager.dao;

import com.dogmanager.bean.User;

public interface IUserDao {

	public User selecUsertById(int id);

	public int addUser(User user);

	public int updateUser(User user);

//	public int deleteUserById(int id);

//	public List<User> getUserList();
}

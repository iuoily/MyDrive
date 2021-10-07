package com.iuoly.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.iuoly.entity.User;

public interface UserDao {

	@Select("select * from t_user where username = #{username}")
	User getUserByName(String username);
	
	/**
	 * 保存用户
	 * @param user
	 */
	@Insert("insert into t_user(id, username, password) values(#{id}, #{username}, #{password})")
	void save(User user);


}

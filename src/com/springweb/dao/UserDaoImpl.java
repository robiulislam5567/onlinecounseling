package com.springweb.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spirngweb.model.User;

@Repository
public class UserDaoImpl {
	private DataSource dataSource;
	private NamedParameterJdbcTemplate jdbc;

	public UserDaoImpl() {
		System.out.println("user dao seccessfully done");
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Transactional
	public boolean Insert(User user) {
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "insert into users(username,password,email,enabled) values(:username,:password,:email,:enabled)";
		String sql1 = "insert into authorities(username,authority)values(:username,:authority)";
		jdbc.update(sql, param);
		return jdbc.update(sql1, param) == 1;
	}

	public List<User> getusers() {
		String sql="select * from users,authorities where users.username=authorities.username";
      return jdbc.query(sql,BeanPropertyRowMapper.newInstance(User.class));
	}
	

}

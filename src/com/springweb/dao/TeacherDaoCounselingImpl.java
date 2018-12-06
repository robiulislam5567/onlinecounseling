package com.springweb.dao;

import java.util.List;

import javax.sql.DataSource;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spirngweb.model.TeacherCounseling;

@Repository
public class TeacherDaoCounselingImpl implements TeacherCounselingDao {
	private DataSource dataSource;
	private NamedParameterJdbcTemplate jdbc;

	public TeacherDaoCounselingImpl() {
		System.out.println("teacher dao seccessfully done");
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<TeacherCounseling> getList() {
		String sql = "select * from teacher";
		return jdbc.query(sql, new Rowmapper());
	}

	@Override
	public boolean addCounseling(TeacherCounseling teacherCounseling) {
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(teacherCounseling);
		String sql = "insert into teacher(day,t_initial_id,time1,time2,time3,time4,time5,time6) values(:day,:t_initial_id,:time1,:time2,:time3,:time4,:time5,:time6)";
		return jdbc.update(sql, param) == 1;
	}

	@Override
	public List<TeacherCounseling> counselingtlist(String t_initial_id) {
		MapSqlParameterSource param=new MapSqlParameterSource("t_initial_id",t_initial_id);
		String sql = "select * from teacher where t_initial_id=:t_initial_id";
		return jdbc.query(sql, param,new Rowmapper());		
	}

	@Override
	public boolean updateCounseling(TeacherCounseling teacherCounseling) {
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(teacherCounseling);
		String sql = "update teacher set time1=:time1,time2=:time2,time3=:time3,time4=:time4,time5=:time5,time6=:time6 where day=:day and t_initial_id=:t_initial_id";
		return jdbc.update(sql, param) == 1;
	}

	

}

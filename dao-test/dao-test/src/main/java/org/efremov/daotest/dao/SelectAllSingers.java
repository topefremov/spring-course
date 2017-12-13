package org.efremov.daotest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.efremov.daotest.domain.Singer;
import org.springframework.jdbc.object.MappingSqlQuery;

public class SelectAllSingers extends MappingSqlQuery<Singer> {
	
	private static final String SQL_SELECT_ALL_SINGERS = 
			"select id, first_name, last_name, birth_date from singer";
	
	public SelectAllSingers(DataSource dataSource) {
		super(dataSource, SQL_SELECT_ALL_SINGERS);
	}
	
	@Override
	protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Singer singer = new Singer();
		
		singer.setId(rs.getLong("id"));
		singer.setFirstName(rs.getString("first_name"));
		singer.setLastName(rs.getString("last_name"));
		singer.setBirthData(rs.getDate("birth_date"));
		
		return singer;
	}

}

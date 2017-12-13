package org.efremov.daotest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.efremov.daotest.domain.Singer;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

public class SelectById extends MappingSqlQuery<Singer> {

	private static final String SQL_FIND_BY_ID = "select id, first_name, last_name, birth_date from singer where id = :id";

	public SelectById(DataSource dataSource) {
		super(dataSource, SQL_FIND_BY_ID);
		super.declareParameter(new SqlParameter("id", Types.INTEGER));
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

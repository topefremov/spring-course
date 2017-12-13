package org.efremov.daotest.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.efremov.daotest.domain.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("singerDao")
public class JdbcSingerDao implements SingerDao {
	
	private DataSource dataSource;
	private SelectAllSingers selectAllSingers;
	private SelectSingerByFirstName selectSingerByFirstName;
	private SelectById selectById;
	
	@Autowired
	public JdbcSingerDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		selectAllSingers = new SelectAllSingers(dataSource);
		selectSingerByFirstName = new SelectSingerByFirstName(dataSource);
		selectById = new SelectById(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Singer> findAll() {
		return selectAllSingers.execute();
	}

	public List<Singer> findByFirstName(String firstName) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("first_name", firstName);
		return selectSingerByFirstName.executeByNamedParam(paramMap);
	}

	@Override
	public Singer findById(Long id) {
		Map<String, Long> paramMap = new HashMap<>();
		paramMap.put("id", id);
		List<Singer> result = selectById.executeByNamedParam(paramMap);
		if (!result.isEmpty()) {
			return selectById.executeByNamedParam(paramMap).get(0);
		}
		return null;
		
	}

}

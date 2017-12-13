package org.efremov.daotest.dao;

import java.util.List;

import org.efremov.daotest.domain.Singer;

public interface SingerDao {
	List<Singer> findAll();

	List<Singer> findByFirstName(String firstName);
	
	Singer findById(Long id);
}

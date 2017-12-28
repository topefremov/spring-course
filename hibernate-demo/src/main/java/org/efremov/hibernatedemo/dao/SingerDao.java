package org.efremov.hibernatedemo.dao;

import java.util.List;

import org.efremov.hibernatedemo.entities.Singer;

public interface SingerDao {
	List<Singer> findAll();
}

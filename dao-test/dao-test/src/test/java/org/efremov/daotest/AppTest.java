package org.efremov.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.efremov.daotest.config.AppConfig;
import org.efremov.daotest.dao.JdbcSingerDao;
import org.efremov.daotest.domain.Singer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	GenericApplicationContext ctx;
	JdbcSingerDao dao;
	
	@Before
	public void init() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		dao = ctx.getBean("singerDao", JdbcSingerDao.class);
	}
	
	@After
	public void destroy() {
		ctx.close();
	}
	
    @Test
	public void dataSourceShouldExistAndWork() throws SQLException {
    	    	DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
    	assertNotNull(dataSource);
    	testDataSource(dataSource);
    }
    
    @Test
    public void dataSourceShouldExistAndWorkInsideDao() throws SQLException {    	
    	DataSource dataSource = dao.getDataSource();
    	assertNotNull(dataSource);
    	testDataSource(dataSource);
    }
    
    @Test
    public void testSelectAll() {
    	List<Singer> mockListOfSingers = new ArrayList<>();
    	mockListOfSingers.add(new Singer(1L,"John", "Mayer", Date.valueOf("1977-10-16")));
    	mockListOfSingers.add(new Singer(2L,"Eric", "Clapton", Date.valueOf("1945-03-30")));
    	mockListOfSingers.add(new Singer(3L,"John", "Butler", Date.valueOf("1975-04-01")));
    	
    	List<Singer> singers = dao.findAll();
    	assertTrue(singers.equals(mockListOfSingers));
    }
    
    @Test
    public void testFindByFirstName() {
    	List<Singer> mockListOfSingers = new ArrayList<>();
    	mockListOfSingers.add(new Singer(1L,"John", "Mayer", Date.valueOf("1977-10-16")));
    	mockListOfSingers.add(new Singer(3L,"John", "Butler", Date.valueOf("1975-04-01")));
    	
    	List<Singer> singers = dao.findByFirstName("John");
    	singers.sort((a, b) -> {
    		return (int) (a.getId() - b.getId());
    	});
    	
    	assertTrue(singers.equals(mockListOfSingers));
    }
    
    @Test
    public void shouldFindById() {
    	Singer john = dao.findById(1L);
    	assertTrue(john.getId() == 1L);
    }
    
    @Test
    public void shouldNotFindById() {
    	assertTrue(dao.findById(10L) == null);
    }
    
    private void testDataSource(DataSource dataSource) throws SQLException {
    	Connection conn;
    	conn = dataSource.getConnection();
    	PreparedStatement statement = conn.prepareStatement("SELECT 2");
    	ResultSet resultSet = statement.executeQuery();
    	while (resultSet.next()) {
    		int mockVal = resultSet.getInt("2");
    		assertTrue(mockVal == 2);
    	}
    	statement.close();
    	try {
    		
    	} 
    	catch (Exception e) {
    		System.out.println("Something unexpected happened " + e);
    	}
    	finally {
    		if (conn != null) {
    			conn.close();
    		}
    	}
    }
}

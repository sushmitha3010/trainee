package com.chainsys.postofficemanagement.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {

	private ConnectionUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("system123");
		dataSource.setPassword("oracle");

		return dataSource;
	}

	public static JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		DataSource dataSource = getDataSource();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
}

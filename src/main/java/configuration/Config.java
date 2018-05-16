package configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dao.interfaces.CustomerCRUD;
import dao.interfaces.TelevisionCRUD;
import dao.services.CustomerCRUDImpl;
import dao.services.TelevisionCRUDImpl;

@Configuration
public class Config {
	@Autowired
	private Environment env;

	@Bean(name = "BookingDataSource")
	public DataSource getBookingDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.bookingDatasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.bookingDatasource.url"));
		dataSource.setUsername(env.getProperty("spring.bookingDatasource.username"));
		dataSource.setPassword(env.getProperty("spring.bookingDatasource.password"));
		return dataSource;
	}
	
	@Bean(name = "TelevisionDataSource")
	public DataSource getTelevisionDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.televisionDatasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.televisionDatasource.url"));
		dataSource.setUsername(env.getProperty("spring.televisionDatasource.username"));
		dataSource.setPassword(env.getProperty("spring.televisionDatasource.password"));
		return dataSource;
	}
	
	@Bean(name = "BookingTemplate")
	public JdbcTemplate BookingjdbcTemplate(@Qualifier("BookingDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "TelevisionTemplate")
	public JdbcTemplate TelevisionJdbcTemplate(@Qualifier("TelevisionDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public CustomerCRUD getCustomerCRUDBean() {
		return new CustomerCRUDImpl();
	}

	@Bean
	public TelevisionCRUD getTelevisionCRUDBean() {
		return new TelevisionCRUDImpl();
	}
	
}

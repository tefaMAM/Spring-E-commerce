package configs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"repoistres","Services","Controller"})
public class DB_Config {
@Bean
public DataSource datasource() {
	var ds=new DriverManagerDataSource();
	ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=Simple_E-commerce;integratedSecurity=false;encrypt=true;trustServerCertificate=true;");
	ds.setUsername("sa");
	ds.setPassword("12345");
	return ds;
}
@Bean
public JdbcTemplate jdbctemplate(DataSource datasource){
	var jt=new JdbcTemplate(datasource);
	return jt;
}
}

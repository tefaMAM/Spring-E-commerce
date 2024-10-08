package configs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"repoistres","Services","Controller"})
public class TransactionalConfig {

	@Bean
	public PlatformTransactionManager ptm(DataSource datasource) {
		var ds=new DataSourceTransactionManager(datasource);
		return ds;
	}
}

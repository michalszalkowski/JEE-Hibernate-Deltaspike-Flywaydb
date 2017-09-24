package pl.btbw.core;

import org.flywaydb.core.Flyway;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;

@Startup
@Singleton(name = "dbMigration")
@TransactionManagement(TransactionManagementType.BEAN)
public class DatabaseMigration {

	@Resource(lookup = "java:jboss/datasources/ExamplePgDS")
	private DataSource dataSource;

	@PostConstruct
	private void onInit() {
		Flyway flyway = new Flyway();
		flyway.setDataSource(dataSource);
		flyway.setSchemas("postgres");
		flyway.setOutOfOrder(true);
		flyway.migrate();
	}
}

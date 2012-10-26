package pl.lrozek.springQuerydsl.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootstrapConfiguration {

    @Bean(destroyMethod = "close")
    public DataSource h2() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName( "net.sf.log4jdbc.DriverSpy" );
        dataSource.setUrl( "jdbc:log4jdbc:h2:~/.querydsl/querydsl;AUTO_SERVER=TRUE" );
        dataSource.setUsername( "sa" );
        return dataSource;
    }

}

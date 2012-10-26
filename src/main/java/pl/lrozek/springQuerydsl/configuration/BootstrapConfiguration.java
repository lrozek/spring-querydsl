package pl.lrozek.springQuerydsl.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.googlecode.flyway.core.Flyway;
import com.mysema.query.sql.H2Templates;
import com.mysema.query.sql.SQLTemplates;

@PropertySource("classpath:/application.props")
@Configuration
public class BootstrapConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource( h2() );
        return flyway;
    }

    @Bean(destroyMethod = "close")
    public DataSource h2() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName( driverClassName );
        dataSource.setUrl( url );
        dataSource.setUsername( username );
        return dataSource;
    }

    @Bean
    public SQLTemplates sqlTemplates() {
        return new H2Templates();
    }

    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

}

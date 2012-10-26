package pl.lrozek.springQuerydsl.start;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.lrozek.springQuerydsl.configuration.BootstrapConfiguration;

public class Main {

    public static void main( String[] args ) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( BootstrapConfiguration.class );
        applicationContext.getBean( DataSource.class ).getConnection();
    }

}

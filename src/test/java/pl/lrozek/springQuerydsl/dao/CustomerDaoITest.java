package pl.lrozek.springQuerydsl.dao;

import static pl.lrozek.springQuerydsl.domain.QCustomer.customer;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.lrozek.springQuerydsl.configuration.BootstrapConfiguration;

import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.dml.SQLInsertClause;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BootstrapConfiguration.class)
public class CustomerDaoITest {

    @Test
    public void itShouldInsertCustomer() throws Exception {
        // given

        // when
        new SQLInsertClause( dataSource.getConnection(), sqlTemplates, customer ).columns( customer.firstname ).values( "customer" ).execute();

        // then
    }

    @Autowired
    private SQLTemplates sqlTemplates;

    @Autowired
    private DataSource dataSource;

}

package com.learning.generators;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class OrderIDGenerator implements IdentifierGenerator {
    private int sequenceValue = 0;

	 @Override
	    public Serializable generate(SharedSessionContractImplementor session, Object object) {
	        // Implement your logic to generate custom primary keys here
	        // For example, you can generate a UUID
		 ++sequenceValue;
	        return "OD" + sequenceValue;
	    }
}
package br.com.pinedu.datasource

import br.com.pinedu.ClienteTenant
import br.com.pinedu.ClienteTenantPropriedades
import grails.util.Holders
import org.grails.datastore.gorm.jdbc.connections.DataSourceConnectionSource
import org.grails.datastore.gorm.jdbc.connections.DataSourceSettings
import org.grails.orm.hibernate.HibernateDatastore
import org.hibernate.Session
import org.springframework.orm.hibernate5.SessionHolder
import org.springframework.transaction.support.TransactionSynchronizationManager

import javax.sql.DataSource
import org.hibernate.SessionFactory
import org.hibernate.Transaction

class PineduTenantHibernateUtil {
	private HibernateDatastore hibernateDatastore
	private DataSourceConnectionSource dataSourceConnectionSource
	private DataSourceSettings dataSourceSettings
	private DataSource dataSource
	private Class[] persistentClasses = new Class[0];
	PineduTenantHibernateUtil(DataSourceConnectionSource dataSourceConnectionSource) {
		this.dataSourceConnectionSource = dataSourceConnectionSource
		this.dataSourceSettings = dataSourceConnectionSource.settings
		this.dataSource = dataSourceConnectionSource.source

	}
	PineduTenantHibernateUtil(DataSourceConnectionSource dataSourceConnectionSource, Class... persistentClasses) {
		this.dataSourceConnectionSource = dataSourceConnectionSource
		this.dataSourceSettings = dataSourceConnectionSource.settings
		this.dataSource = dataSourceConnectionSource.source
		this.persistentClasses = persistentClasses
	}
	SessionFactory getSessionFactory() {
		if ( this.hibernateDatastore == null ) {
			def x = Holders.grailsApplication.mainContext
			hibernateDatastore = Holders.grailsApplication.mainContext.getBean('hibernateDatastore')
		}
		return hibernateDatastore.getSessionFactory()
	}
	public execute(Closure exec) {
		//def oldSessionFactory = Holders.grailsApplication.mainContext.getBean('sessionFactory')
		//Object oldSession = TransactionSynchronizationManager.unbindResource(oldSessionFactory);
		//

		SessionFactory sessionFactory = getSessionFactory()
		Session session = sessionFactory.openSession()
		//TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
		//Transaction transaction = session.beginTransaction()
		org.grails.datastore.mapping.multitenancy.web.SessionTenantResolver x
		org.grails.datastore.mapping.multitenancy.web.SubDomainTenantResolver y
		//def transaction = session.beginTransaction()
		org.grails.orm.hibernate.GrailsHibernateTemplate g
		ClienteTenantPropriedades.all()
		try {
			exec()
			//transaction.commit()  // Confirmar a transação
		} catch (Exception e) {
			//transaction.rollback()  // Reverter a transação em caso de erro
			e.printStackTrace()
		} finally {
			//session.close()  // Fechar a sessão
			//TransactionSynchronizationManager.unbindResource(sessionFactory);
			//
			//TransactionSynchronizationManager.bindResource(oldSessionFactory, oldSession);
		}
	}
}

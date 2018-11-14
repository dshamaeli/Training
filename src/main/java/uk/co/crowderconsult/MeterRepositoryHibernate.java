package uk.co.crowderconsult;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class MeterRepositoryHibernate implements MeterRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MeterRepositoryHibernate.class);

    final SessionFactory factory = new Configuration()
            .addPackage("uk.co.crowderconsult")
            .setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver")
            .setProperty("hibernate.connection.url", "jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT9")
            .setProperty("hibernate.connection.username", "nb")
            .setProperty("hibernate.connection.password", "NB")
            .setProperty("hibernate.dialec", "org.hibernate.dialect.Oracle10gDialect")
            .addAnnotatedClass(Meter.class)
            .buildSessionFactory();
    Session session = factory.openSession();

    @Override
    public List<Meter> getAllMeters(Area area) {
        final String column = "id";//NON-NLS
        Integer areaId = area.getAreaId();
        List<Meter> list = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Criteria createCriteria = session.createCriteria(Meter.class);
            createCriteria.add(Restrictions.eq(column, areaId));
            list = createCriteria.list();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e);
//            LOG.error("Error", e);//NON-NLS
        } finally {
            session.close();
        }
        return list;
    }


    @Override
    public List<Meter> getOldMeter(Date date) {
        List<Meter> list = null;
        java.sql.Date dateSQL = new java.sql.Date(date.getTime());
        String column = "installDate";//NON-NLS
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Criteria createCriteria = session.createCriteria(Meter.class);
            createCriteria.add(Restrictions.le(column, dateSQL));
            list = createCriteria.list();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e);
//            LOG.error("Error", e);//NON-NLS
        } finally {
            session.close();
        }
        return list;
    }
}

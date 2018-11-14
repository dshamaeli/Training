package uk.co.crowderconsult;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * @author Daniel.shamaeli
 */
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
            .addAnnotatedClass(Area.class)
            .buildSessionFactory();

    @Override
    public List<Meter> getAllMeters(Area area) {
        final String sql = "select m.* from Meter m, AREA_METER_LOOKUP a where m.meter_id = a.meter_id and a.area_id = :area_id";//NON-NLS
        Session session = factory.openSession();
        SQLQuery query = session.createSQLQuery(sql);
        Integer areaId = area.getAreaId();
        List<Meter> list = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            query.addEntity(Meter.class).setParameter("area_id", areaId);
            list = query.list();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            LOG.error("Error", e);//NON-NLS
        } finally {
            session.close();
        }
        return list;
    }


    @Override
    public List<Meter> getOldMeter(Date date) {
        Session session = factory.openSession();
        List<Meter> list = null;
        java.sql.Date dateSQL = new java.sql.Date(date.getTime());
        String column = "installDate";//NON-NLS
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria createCriteria = session.createCriteria(Meter.class);
            createCriteria.add(Restrictions.le(column, dateSQL));
            list = createCriteria.list();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            LOG.error("Error", e);//NON-NLS
        } finally {
            session.close();
        }
        return list;
    }
}

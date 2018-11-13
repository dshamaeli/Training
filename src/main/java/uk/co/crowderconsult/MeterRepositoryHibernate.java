package uk.co.crowderconsult;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeterRepositoryHibernate implements MeterRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MeterRepositoryHibernate.class);

    final SessionFactory factory = new Configuration()
            .addPackage("uk.co.crowderconsult")
            .setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver")
            .setProperty("hibernate.connection.url", "jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT9")
            .setProperty("hhibernate.connection.username", "nb")
            .setProperty("hibernate.connection.password", "NB")
            .setProperty("hibernate.dialec", "org.hibernate.dialect.Oracle10gDialect")
            .addAnnotatedClass(Meter.class)
            .buildSessionFactory();
    Session session = factory.openSession();
    Criteria cr = session.createCriteria(Meter.class);

    private List<Meter> getMeterQuery(String query) {
        Transaction transaction = null;
        List<Meter> list = null;
        try {
            transaction = session.beginTransaction();
            list = session.createQuery(query).list();
            transaction.commit();
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
    public List<Meter> getAllMeters(Area area) {
        final String query = "from Meter m, AREA_METER_LOOKUP a where m.meter_id = a.meter_id and a.area_id = 321 ";
        List<Meter> list;
        list = getMeterQuery(query);
        return list;
    }

    @Override
    public List<Meter> getOldMeter(Date date) {
        ResultSet result;
        java.sql.Date dateSQL = new java.sql.Date(date.getTime());
        List<Meter> list = new ArrayList<>();
        String query = "select * from meter where install_date < ?";//NON-NLS
        list = getMeterQuery(query);
        return list;
    }
}

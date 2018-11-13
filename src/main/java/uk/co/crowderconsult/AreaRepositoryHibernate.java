package uk.co.crowderconsult;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AreaRepositoryHibernate implements AreaRepository {
    private static final Logger LOG = LoggerFactory.getLogger(AreaRepositoryHibernate.class);

//    private static SessionFactory factory;

//    {
//        try {
//            factory = new Configuration().configure().buildSessionFactory();
//        } catch (HibernateException e) {
//            System.out.println(e);
//            LOG.error("Failed to create sessionFactory object.", e);//NON-NLS
//        }
//    }

    final Configuration cfg = new Configuration()
            .addPackage("uk.co.crowderconsult")
            .setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver")
            .setProperty("hibernate.connection.url", "jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT9")
            .setProperty("hibernate.connection.username", "nb")
            .setProperty("hibernate.connection.password", "NB")
            .setProperty("hibernate.dialec", "org.hibernate.dialect.Oracle10gDialect")
            .setProperty("hibernate.show_sql", "true")
            .addAnnotatedClass(Area.class);
    SessionFactory factory = cfg.buildSessionFactory();

    private List<Area> getAreaQuery(String query) {

        Session session = factory.openSession();
        Transaction transaction = null;
        List<Area> list = null;
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
    public List<Area> getAllAreas() {
        final String query = "From Area";
        List<Area> list;
        list = getAreaQuery(query);
        return list;
    }

    @Override
    public List<Area> getActiveAreas() {
//        final String query = "from Area where upper(is_active)='Y'";
        final String query = "From Area";
        List<Area> list;
        list = getAreaQuery(query);
        return list;
    }
}

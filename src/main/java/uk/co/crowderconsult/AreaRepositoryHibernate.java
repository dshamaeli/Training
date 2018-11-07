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
    private static final Logger LOG = LoggerFactory.getLogger(AreaRepositoryJDBC.class);

    private static SessionFactory factory;

    {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println(e);
            LOG.error("Failed to create sessionFactory object.", e);//NON-NLS
        }
    }

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
            LOG.error("Error", e);//NON-NLS
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
        final String query = "from Area where upper(is_active)='Y'";
        List<Area> list;
        list = getAreaQuery(query);
        return list;
    }
}

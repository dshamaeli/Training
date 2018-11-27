package uk.co.crowderconsult.Model.area;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.crowderconsult.Model.meter.Meter;

import java.util.List;

/**
 * @author Daniel.shamaeli
 */
public class AreaRepositoryHibernate implements AreaRepository, AreaCRUD {
    private static final Logger LOG = LoggerFactory.getLogger(AreaRepositoryHibernate.class);
    final Configuration cfg = new Configuration()
            .addPackage("uk.co.crowderconsult")
            .setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver")
            .setProperty("hibernate.connection.url", "jdbc:oracle:thin:@CCVMRELEASE:1521:NIGHT5")
            .setProperty("hibernate.connection.username", "nb")
            .setProperty("hibernate.connection.password", "NB")
            .setProperty("hibernate.dialec", "org.hibernate.dialect.Oracle10gDialect")
            .setProperty("hibernate.show_sql", "false")
            .addAnnotatedClass(Area.class)
            .addAnnotatedClass(Meter.class);
    private SessionFactory factory = cfg.buildSessionFactory();

    private <T> List<Area> getAreaQuery(String propertyname, T param) {
        Transaction transaction = null;
        List<Area> list = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            Criteria createCriteria = session.createCriteria(Area.class);
            if (propertyname != null) {
                createCriteria.add(Restrictions.eq(propertyname, param));
            }
            list = createCriteria.list();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            LOG.error("Error", e);//NON-NLS
        }
        return list;
    }

    @Override
    public List<Area> getAllAreas() {
        List<Area> list;
        list = getAreaQuery(null, null);
        return list;
    }

    @Override
    public List<Area> getActiveAreas() {
        final String column = "isActive";
        List<Area> list;
        list = getAreaQuery(column, true);
        return list;
    }

    @Override
    public void addArea(Area area) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            System.out.println("Start Transaction");
            transaction = session.beginTransaction();
            session.save(area);
            transaction.commit();
            System.out.println("area saved\n" + area);
        } catch (HibernateException e) {
            System.out.println("Catch error when add");
            if (transaction != null) transaction.rollback();
            System.out.println(e);
            LOG.error("Error", e);//NON-NLS
        } finally {
            System.out.println("save finally ");
            session.close();
        }
    }

    @Override
    public void editArea(Area area) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            System.out.println("Start Transaction");
            transaction = session.beginTransaction();
            session.update(area);
            transaction.commit();
            System.out.println("area deleted\n" + area);
        } catch (HibernateException e) {
            System.out.println("Catch error when delete");
            if (transaction != null) transaction.rollback();
            System.out.println(e);
            LOG.error("Error", e);//NON-NLS
        } finally {
            System.out.println("finally finally");
            session.close();
        }

    }

    @Override
    public void deleteArea(Area area) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            System.out.println("Start Transaction");
            transaction = session.beginTransaction();
            session.delete(area);
            transaction.commit();
            System.out.println("area deleted\n" + area);
        } catch (HibernateException e) {
            System.out.println("Catch error when delete");
            if (transaction != null) transaction.rollback();
            System.out.println(e);
            LOG.error("Error", e);//NON-NLS
        } finally {
            System.out.println("finally finally");
            session.close();
        }
    }
}

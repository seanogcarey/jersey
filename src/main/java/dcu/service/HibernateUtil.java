package dcu.service;

/**
 * Created by Sean on 08/03/2016.
 */
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Sean on 01/03/2016.
 */

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {

            Configuration configuration = new Configuration();
            System.out.println("Going to hibernate config file");
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();


        } catch (Throwable e) {
            e.printStackTrace();
            System.err.println("Error in creating SessionFactory object."
                    + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

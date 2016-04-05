package dcu;

/**
 * Created by Sean on 08/03/2016.
 */
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Sean on 01/03/2016.
 */
public class SessionFactoryHelper {
    private static final SessionFactory sessionFactory;

    static {
        try {
            //
            // Build a SessionFactory object from session-factory configuration
            // defined in the hibernate.cfg.xml file. In this file we register
            // the JDBC connection information, connection pool, the hibernate
            // dialect that we used and the mapping to our hbm.xml file for each
            // Pojo (Plain Old Java Object).
/*
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
*/

            Configuration configuration = new Configuration();
            System.out.println("going to hibernate config file");
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();


        } catch (Throwable e) {
            e.printStackTrace();
            System.err.println("Error in creating SessionFactory object."
                    + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * A static method for other application to get SessionFactory object
     * initialized in this helper class.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

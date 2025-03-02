package lesson20;

import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateHelper {

    private static final Configuration CONFIG = new Configuration().configure();

    public Session getSession() {
        return CONFIG.buildSessionFactory().openSession();
    }

}
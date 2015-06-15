package zmz.hf.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
    private HibernateUtil(){}
    static {
    	Configuration conf = new Configuration()
		.configure("hibernate.cfg.xml");
    	 sessionFactory = conf.buildSessionFactory();
    }
    
    public static SessionFactory getSessionFactory(){ 
        return sessionFactory;
    }
    public static Session getSession() {
        return sessionFactory.openSession();
    }
}

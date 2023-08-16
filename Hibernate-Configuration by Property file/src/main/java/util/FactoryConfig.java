package util;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfig {
    private static FactoryConfig factoryConfig;
    private SessionFactory sessionFactory;

    private FactoryConfig(){
        Configuration configuration = new Configuration();

        Properties properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Student.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfig getInstance(){
        return factoryConfig == null ? (factoryConfig = new FactoryConfig()) : factoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}

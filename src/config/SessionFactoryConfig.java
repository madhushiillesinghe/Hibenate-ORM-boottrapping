package config;

import entity.Customer;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {
    //1.use the singleton
    private static  SessionFactoryConfig factoryConfig;
    private SessionFactoryConfig(){
    }
    public static SessionFactoryConfig getInstance(){
        return (factoryConfig==null?new SessionFactoryConfig():factoryConfig);
    }
    public Session getSession(){
        // create service register
       StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().configure().build();

       //2.create meta data Object
      Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Employee.class)
                .getMetadataBuilder()
                .build();

      //3.create session factory
        SessionFactory sessionFactory = metadata.buildSessionFactory();

       return sessionFactory.openSession();
    }
}
